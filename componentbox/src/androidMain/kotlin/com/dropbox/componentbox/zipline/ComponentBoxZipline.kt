@file:Suppress("UNCHECKED_CAST")

package com.dropbox.componentbox.zipline

import app.cash.zipline.Zipline
import com.dropbox.componentbox.foundation.COMPONENT_BOX_ZIPLINE_SERVICE
import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.foundation.ComponentBoxType
import com.dropbox.componentbox.presentation.ComponentBoxViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import java.util.concurrent.Executors
import kotlin.coroutines.EmptyCoroutineContext

class ComponentBoxZipline(
    val ziplineUrl: String,
    val script: String,
    val headers: Map<String, String> = mapOf(),
) {
    val executorService = Executors.newSingleThreadExecutor { Thread(it, "Zipline") }
    val dispatcher = executorService.asCoroutineDispatcher()
    val zipline = Zipline.create(dispatcher)
    val client = OkHttpClient()
    val hostApi = RealHostApi(client)

    inline fun <reified C : ComponentBox> produceModelsIn(
        componentBoxUrl: String,
        coroutineScope: CoroutineScope,
        modelsStateFlow: MutableStateFlow<ComponentBoxViewModel<C>>
    ) {
        val job = coroutineScope.launch(dispatcher) {
            val componentBoxJs = hostApi.httpCall(ziplineUrl, mapOf())
            zipline.loadJsModule(componentBoxJs, MODULE_NAME)
            zipline.bind<HostApi>("hostApi", hostApi)
            zipline.quickJs.evaluate(script)

            val presenter: ComponentBoxZiplineService = zipline.take(COMPONENT_BOX_ZIPLINE_SERVICE)

            val modelsFlow: Flow<ComponentBoxViewModel<C>>? = when (C::class) {
                ComponentBox.Banner::class -> presenter.produceModels<ComponentBox.Banner>(
                    ComponentBoxType.Banner,
                    componentBoxUrl,
                    headers
                ) as Flow<ComponentBoxViewModel<C>>
                ComponentBox.Modal::class -> presenter.produceModels<ComponentBox.Modal>(
                    ComponentBoxType.Modal,
                    componentBoxUrl,
                    headers
                ) as Flow<ComponentBoxViewModel<C>>
                ComponentBox.Screen::class -> presenter.produceModels<ComponentBox.Screen>(
                    ComponentBoxType.Screen,
                    componentBoxUrl,
                    headers
                ) as Flow<ComponentBoxViewModel<C>>
                else -> null
            }

            if (modelsFlow != null) {
                modelsStateFlow.emitAll(modelsFlow)
            }
        }

        job.invokeOnCompletion {
            dispatcher.dispatch(EmptyCoroutineContext) { zipline.close() }
            executorService.shutdown()
        }
    }

    companion object {
        const val MODULE_NAME = "zipline"
    }
}