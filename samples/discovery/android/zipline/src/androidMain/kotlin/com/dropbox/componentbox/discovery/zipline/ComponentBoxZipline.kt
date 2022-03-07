package com.dropbox.componentbox.discovery.zipline

import app.cash.zipline.Zipline
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

    fun produceModelsInScreen(
        id: String,
        coroutineScope: CoroutineScope,
        modelsStateFlow: MutableStateFlow<ComponentBoxScreenViewModel>
    ) {
        val job = coroutineScope.launch(dispatcher) {
            val componentBoxJs = hostApi.httpCall("$ROOT_URL/$FILE", mapOf())
            zipline.loadJsModule(componentBoxJs, MODULE_NAME)
            zipline.bind<HostApi>("hostApi", hostApi)
            zipline.quickJs.evaluate(LOAD_COMPONENT_BOX_SCRIPT)

            val presenter = zipline.take<ComponentBoxScreenPresenter>(ComponentBoxType.Screen.presenterName())
            val modelsFlow = presenter.produceModels(id)
            modelsStateFlow.emitAll(modelsFlow)
        }

        job.invokeOnCompletion {
            dispatcher.dispatch(EmptyCoroutineContext) { zipline.close() }
            executorService.shutdown()
        }
    }

    fun produceModelsInBanner(
        id: String,
        coroutineScope: CoroutineScope,
        modelsStateFlow: MutableStateFlow<ComponentBoxBannerViewModel>
    ) {
        val job = coroutineScope.launch(dispatcher) {
            val componentBoxJs = hostApi.httpCall("$ROOT_URL/$FILE", mapOf())
            zipline.loadJsModule(componentBoxJs, MODULE_NAME)
            zipline.bind<HostApi>("hostApi", hostApi)
            zipline.quickJs.evaluate(LOAD_COMPONENT_BOX_SCRIPT)

            val presenter = zipline.take<ComponentBoxBannerPresenter>(ComponentBoxType.Banner.presenterName())
            val modelsFlow = presenter.produceModels(id)
            modelsStateFlow.emitAll(modelsFlow)
        }

        job.invokeOnCompletion {
            dispatcher.dispatch(EmptyCoroutineContext) { zipline.close() }
            executorService.shutdown()
        }
    }

    fun produceModelsInModal(
        id: String,
        coroutineScope: CoroutineScope,
        modelsStateFlow: MutableStateFlow<ComponentBoxModalViewModel>
    ) {
        val job = coroutineScope.launch(dispatcher) {
            val componentBoxJs = hostApi.httpCall("$ROOT_URL/$FILE", mapOf())
            zipline.loadJsModule(componentBoxJs, MODULE_NAME)
            zipline.bind<HostApi>("hostApi", hostApi)
            zipline.quickJs.evaluate(LOAD_COMPONENT_BOX_SCRIPT)

            val presenter = zipline.take<ComponentBoxModalPresenter>(ComponentBoxType.Modal.presenterName())
            val modelsFlow = presenter.produceModels(id)
            modelsStateFlow.emitAll(modelsFlow)
        }

        job.invokeOnCompletion {
            dispatcher.dispatch(EmptyCoroutineContext) { zipline.close() }
            executorService.shutdown()
        }
    }

    companion object {
        private const val MODULE_NAME = "zipline"
        private const val ROOT_URL = "http://10.0.2.2:8080"
        private const val FILE = "$MODULE_NAME.js"
        private const val LOAD_COMPONENT_BOX_SCRIPT =
            "require('$MODULE_NAME').com.dropbox.componentbox.discovery.zipline.loadComponentBox()"
    }
}

