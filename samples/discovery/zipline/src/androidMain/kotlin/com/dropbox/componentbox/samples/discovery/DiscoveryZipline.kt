package com.dropbox.componentbox.samples.discovery

import app.cash.zipline.Zipline
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import okhttp3.OkHttpClient
import java.util.concurrent.Executors
import kotlin.coroutines.EmptyCoroutineContext

class DiscoveryZipline {
    private val executorService = Executors.newSingleThreadExecutor { Thread(it, "Zipline") }
    private val dispatcher = executorService.asCoroutineDispatcher()
    private val zipline = Zipline.create(dispatcher)
    private val client = OkHttpClient()
    private val hostApi = RealHostApi(client)

    fun produceModelsIn(
        coroutineScope: CoroutineScope,
        eventFlow: Flow<DiscoveryEvent>,
        modelsStateFlow: MutableStateFlow<DiscoveryScreenViewModel>
    ) {

        val job = coroutineScope.launch(dispatcher) {
            val presentersJs = hostApi.httpCall("$ROOT_URL/$FILE", mapOf())
            zipline.loadJsModule(presentersJs, MODULE_NAME)
            zipline.bind<HostApi>("hostApi", hostApi)
            zipline.quickJs.evaluate(PREPARE_PRESENTERS_SCRIPT)
            val presenter = zipline.take<DiscoveryPresenter>("discoveryPresenter")
            val modelsFlow = presenter.produceModels()
            modelsStateFlow.emitAll(modelsFlow)
        }

        job.invokeOnCompletion {
            dispatcher.dispatch(EmptyCoroutineContext) { zipline.close() }
            executorService.shutdown()
        }
    }
}

private const val MODULE_NAME = "zipline"
private const val ROOT_URL = "http://10.0.2.2:8080"
private const val FILE = "$MODULE_NAME.js"
private const val PREPARE_PRESENTERS_SCRIPT =
    "require('$MODULE_NAME').com.dropbox.componentbox.samples.discovery.preparePresenters()"