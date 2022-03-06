package com.dropbox.componentbox.samples.discovery

import app.cash.zipline.Zipline
import com.dropbox.componentbox.models.ComponentBox
import com.dropbox.componentbox.models.ComponentBoxType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import java.util.concurrent.Executors
import kotlin.coroutines.EmptyCoroutineContext

class ComponentBoxZipline {
    private val executorService = Executors.newSingleThreadExecutor { Thread(it, "Zipline") }
    private val dispatcher = executorService.asCoroutineDispatcher()
    private val zipline = Zipline.create(dispatcher)
    private val client = OkHttpClient()
    private val hostApi = RealHostApi(client)

    inline fun <reified C : ComponentBox> load(
        id: String,
        coroutineScope: CoroutineScope,
        modelsStateFlow: MutableStateFlow<ComponentBoxViewModel<C>>
    ) {
        produceModelsIn(id, componentBoxType<C>(), coroutineScope, modelsStateFlow)
    }

    fun <C : ComponentBox> produceModelsIn(
        id: String,
        type: ComponentBoxType?,
        coroutineScope: CoroutineScope,
        modelsStateFlow: MutableStateFlow<ComponentBoxViewModel<C>>
    ) {

        val job = coroutineScope.launch(dispatcher) {
            val componentBoxJs = hostApi.httpCall("$ROOT_URL/$FILE", mapOf())
            zipline.loadJsModule(componentBoxJs, MODULE_NAME)
            zipline.bind<HostApi>("hostApi", hostApi)
            zipline.quickJs.evaluate(LOAD_COMPONENT_BOX_SCRIPT)

            val presenter = zipline.take<ComponentBoxPresenter<C>>(type.presenterName())
            val modelsFlow = presenter.produceModels(id, type)
            modelsStateFlow.emitAll(modelsFlow)
        }

        job.invokeOnCompletion {
            dispatcher.dispatch(EmptyCoroutineContext) { zipline.close() }
            executorService.shutdown()
        }
    }
}

inline fun <reified C : ComponentBox> componentBoxType() = when (C::class) {
    ComponentBox.Modal::class -> ComponentBoxType.Modal
    ComponentBox.Screen::class -> ComponentBoxType.Screen
    ComponentBox.Banner::class -> ComponentBoxType.Banner
    else -> null
}

private const val MODULE_NAME = "zipline"
private const val ROOT_URL = "http://10.0.2.2:8080"
private const val FILE = "$MODULE_NAME.js"
private const val LOAD_COMPONENT_BOX_SCRIPT =
    "require('$MODULE_NAME').com.dropbox.componentbox.discovery.android.zipline.componentbox.loadComponentBox()"
