package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import app.cash.zipline.Zipline
import app.cash.zipline.loader.LoadResult
import app.cash.zipline.loader.ZiplineLoader
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

fun campaignsComponentBoxModelStateFlow(
    coroutineScope: CoroutineScope,
    ziplineLoader: ZiplineLoader,
    ziplineMetadata: ZiplineMetadata,
    ziplineInitializer: (Zipline) -> Unit = {}
): StateFlow<CampaignsComponentBoxModel?> {
    val model = MutableStateFlow<CampaignsComponentBoxModel?>(null)

    coroutineScope.launch(coroutineScope.coroutineContext + SupervisorJob()) {
        var job: Job? = null

        println("TRYING TO LOAD ZIPLINE")
        val ziplineResult = ziplineLoader.loadOnce(ziplineMetadata.applicationName, ziplineMetadata.manifestUrl, initializer = ziplineInitializer)

        println("ZIPLINE RESULT === $ziplineResult")
        if (ziplineResult is LoadResult.Success) {
            val service = ziplineResult.zipline.take<CampaignsComponentBoxService>(ziplineMetadata.serviceName)
            println("SERVICE ==== $service")
            //   val loadModel = launch { service.loadComponentBoxModel().collect { model.value = it } }
            //   job = loadModel
            println("HITTING IN STATEFLOW")

            launch { model.value = FakeCampaignsComponentBoxModel() }
        } else if (ziplineResult is LoadResult.Failure) {
            println("HITTING IN STATEFLOW -- FAIL")
            println("${ziplineResult.exception}")

        }

    }
    return model
}