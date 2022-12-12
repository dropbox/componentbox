package com.dropbox.componentbox.zipline

import app.cash.zipline.Zipline
import app.cash.zipline.loader.LoadResult
import app.cash.zipline.loader.ZiplineLoader
import com.dropbox.componentbox.foundation.ComponentBoxEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

inline fun <reified Service : ComponentBoxService<Model, State, Event>, Model : ComponentBoxModel<State, Event>, State : ComponentBoxState, Event : ComponentBoxEvent> componentBoxModelStateFlow(
    coroutineScope: CoroutineScope,
    ziplineLoader: ZiplineLoader,
    ziplineMetadata: ZiplineMetadata,
    noinline ziplineInitializer: (Zipline) -> Unit = {}
): StateFlow<Model?> {
    val model = MutableStateFlow<Model?>(null)

    coroutineScope.launch(coroutineScope.coroutineContext + SupervisorJob()) {
        var job: Job? = null

        val ziplineResult = ziplineLoader.loadOnce(ziplineMetadata.applicationName, ziplineMetadata.manifestUrl, initializer = ziplineInitializer)
        if (ziplineResult is LoadResult.Success) {
            val service = ziplineResult.zipline.take<Service>(ziplineMetadata.serviceName)

            val loadModel = launch {
                model.value = service.load()
            }

            job = loadModel
        }

    }
    return model
}