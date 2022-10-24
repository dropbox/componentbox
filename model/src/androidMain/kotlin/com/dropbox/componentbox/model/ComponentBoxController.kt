package com.dropbox.componentbox.model

import app.cash.zipline.Zipline
import app.cash.zipline.loader.ManifestVerifier
import app.cash.zipline.loader.ZiplineLoader
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient
import java.util.concurrent.Executors

class ComponentBoxController<Model : ComponentBoxModel<*, *>>(
    private val manifestUrl: String,
    private val applicationName: String,
    private val serviceName: String
) {
    private val ziplineExecutorService = Executors.newSingleThreadExecutor { Thread(it, "Zipline") }
    private val ziplineDispatcher = ziplineExecutorService.asCoroutineDispatcher()
    private val okHttpClient = OkHttpClient()

    private val ziplineLoader = ZiplineLoader(
        dispatcher = ziplineDispatcher,
        manifestVerifier = ManifestVerifier.NO_SIGNATURE_CHECKS,
        httpClient = okHttpClient
    )

    internal inline fun <reified Service : ComponentBoxService<Model>> models(
        noinline initializer: (Zipline) -> Unit = {}
    ): Flow<Model> = flowOfModels<Model, Service>(
        dispatcher = ziplineDispatcher,
        ziplineLoader = ziplineLoader,
        manifestUrl = manifestUrl,
        applicationName = applicationName,
        serviceName = serviceName,
        initializer = initializer
    )
}