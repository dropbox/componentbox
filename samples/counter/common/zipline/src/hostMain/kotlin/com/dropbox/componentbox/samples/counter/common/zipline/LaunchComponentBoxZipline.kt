package com.dropbox.componentbox.samples.counter.common.zipline

import app.cash.zipline.loader.LoadResult
import app.cash.zipline.loader.ZiplineLoader
import com.dropbox.componentbox.Component
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

fun launchComponentBoxZipline(
        scope: CoroutineScope,
        ziplineDispatcher: CoroutineDispatcher,
        ziplineLoader: ZiplineLoader,
        manifestUrl: String,
        componentBox: MutableStateFlow<Component?>
) {
    scope.launch(ziplineDispatcher + SupervisorJob()) {
        val result = ziplineLoader.loadOnce(
                applicationName = "counter",
                manifestUrl = manifestUrl
        )

        if (result is LoadResult.Success) {
            val zipline = result.zipline
            val componentBoxZipline = zipline.take<ComponentBoxZipline>("ComponentBoxZipline")

            val job = launch {
                componentBox.value = componentBoxZipline.root
            }

            job.invokeOnCompletion {
                componentBoxZipline.close()
            }
        }
    }
}