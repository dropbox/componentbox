package com.dropbox.componentbox.model

import app.cash.zipline.Zipline
import app.cash.zipline.loader.ZiplineLoader
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch

inline fun <Model : ComponentBoxModel<*, *, *>, reified Service : ComponentBoxService<Model>> flowOfModels(
    dispatcher: CoroutineDispatcher,
    ziplineLoader: ZiplineLoader,
    manifestUrl: String,
    applicationName: String,
    serviceName: String,
    noinline initializer: (Zipline) -> Unit = {}
): Flow<Model> {

    val scope = CoroutineScope(dispatcher)
    val models = MutableSharedFlow<Model>()

    scope.launch(dispatcher + SupervisorJob()) {
        var job: Job? = null

        val zipline =
            ziplineLoader.loadOnce(applicationName, manifestUrl, initializer = initializer).zipline
        val service = zipline.take<Service>(serviceName)

        val emitModels = launch {
            models.emitAll(service.models())
        }

        job = emitModels
    }

    return models
}