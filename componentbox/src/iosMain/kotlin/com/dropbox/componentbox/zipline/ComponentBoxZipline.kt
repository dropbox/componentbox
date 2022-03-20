package com.dropbox.componentbox.zipline

import app.cash.zipline.Zipline
import com.dropbox.componentbox.foundation.COMPONENT_BOX_ZIPLINE_SERVICE
import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.presentation.ComponentBoxViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import kotlin.coroutines.EmptyCoroutineContext

class ComponentBoxZipline(
    val ziplineUrl: String,
    val script: String,
    val headers: Map<String, String> = mapOf()
) {
    val dispatcher = Dispatchers.Default
    val zipline = Zipline.create(dispatcher)
    val componentBoxApi = RealComponentBoxApi()

    inline fun <reified C : ComponentBox> produceModelsIn(
        componentBoxUrl: String,
        coroutineScope: CoroutineScope,
        modelsStateFlow: MutableStateFlow<ComponentBoxViewModel<C>>
    ) {
        val job = coroutineScope.launch(dispatcher) {
            val componentBoxJs = componentBoxApi.httpCall(ziplineUrl, headers)
            zipline.loadJsModule(componentBoxJs, MODULE_NAME)
            zipline.bind<ComponentBoxApi>("componentBoxApi", componentBoxApi)
            zipline.quickJs.evaluate(script, componentBoxJs)

            val presenter: ComponentBoxZiplineService = zipline.take(COMPONENT_BOX_ZIPLINE_SERVICE)
            val modelsFlow: Flow<ComponentBoxViewModel<C>>? = presenter.produceModels(componentBoxUrl, headers)
            if (modelsFlow != null) {
                modelsStateFlow.emitAll(modelsFlow)
            }
        }

        job.invokeOnCompletion {
            dispatcher.dispatch(EmptyCoroutineContext, Runnable { zipline.close() })
        }
    }

    companion object {
        const val MODULE_NAME = "zipline"
    }

}