package com.dropbox.componentbox.samples.counter.common.zipline

import app.cash.zipline.loader.ManifestVerifier
import app.cash.zipline.loader.ZiplineLoader
import com.dropbox.componentbox.Component
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import okhttp3.OkHttpClient
import java.util.concurrent.Executors

class ComponentBoxService(
        private val scope: CoroutineScope
) {
    private val ziplineExecutorService = Executors.newSingleThreadExecutor { Thread(it, "Zipline") }
    private val ziplineDispatcher = ziplineExecutorService.asCoroutineDispatcher()
    private val okHttpClient = OkHttpClient()

    private val stateFlow: MutableStateFlow<Component?> = MutableStateFlow(null)
    val componentBox: StateFlow<Component?> = stateFlow


    fun launch(manifestUrl: String) {
        launchComponentBoxZipline(
                scope = scope,
                ziplineDispatcher = ziplineDispatcher,
                ziplineLoader = ZiplineLoader(
                        dispatcher = ziplineDispatcher,
                        manifestVerifier = ManifestVerifier.NO_SIGNATURE_CHECKS,
                        httpClient = okHttpClient
                ),
                manifestUrl = manifestUrl,
                componentBox = stateFlow,
        )
    }

    fun close() {
        ziplineExecutorService.shutdown()
    }
}