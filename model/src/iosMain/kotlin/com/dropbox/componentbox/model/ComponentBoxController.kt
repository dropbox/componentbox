package com.dropbox.componentbox.model

import app.cash.zipline.Zipline
import app.cash.zipline.loader.ManifestVerifier
import app.cash.zipline.loader.ZiplineLoader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import platform.Foundation.NSURLSession

actual class ComponentBoxController<Model : ComponentBoxModel<*, State, Event>, State : ComponentBoxState, Event : ComponentBoxEvent>(
    val manifestUrl: String,
    val applicationName: String,
    val serviceName: String
) {

    val ziplineDispatcher = Dispatchers.Main
    private val urlSession = NSURLSession.sharedSession

    val ziplineLoader = ZiplineLoader(
        dispatcher = ziplineDispatcher,
        manifestVerifier = ManifestVerifier.NO_SIGNATURE_CHECKS,
        urlSession = urlSession
    )

    actual inline fun <reified Service : ComponentBoxService<Model>> models(
        noinline initializer: (Zipline) -> Unit
    ): Flow<Model> = flowOfModels<Model, Service>(
        dispatcher = ziplineDispatcher,
        ziplineLoader = ziplineLoader,
        manifestUrl = manifestUrl,
        applicationName = applicationName,
        serviceName = serviceName,
        initializer = initializer
    )
}