package com.dropbox.componentbox.model

import app.cash.zipline.Zipline
import app.cash.zipline.loader.ZiplineLoader
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

inline fun <reified Service : ComponentBoxService<Model, State>, Model : ComponentBoxModel<State>, State : ComponentBoxState> componentBoxModelStateFlow(
    coroutineScope: CoroutineScope,
    ziplineLoader: ZiplineLoader,
    serviceCoordinates: ServiceCoordinates,
    noinline initializer: (Zipline) -> Unit = {}
): StateFlow<Model?> {
    val model = MutableStateFlow<Model?>(null)

    coroutineScope.launch(coroutineScope.coroutineContext + SupervisorJob()) {
        var job: Job? = null

        val zipline = ziplineLoader.loadOnce(serviceCoordinates.applicationName, serviceCoordinates.manifestUrl, initializer = initializer).zipline
        val service = zipline.take<Service>(serviceCoordinates.serviceName)

        val loadModel = launch {
            model.value = service.load(service.componentBoxUrl)
        }

        job = loadModel
    }
    return model
}