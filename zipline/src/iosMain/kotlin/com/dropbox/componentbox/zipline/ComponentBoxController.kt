package com.dropbox.componentbox.zipline

import app.cash.zipline.Zipline
import app.cash.zipline.loader.ManifestVerifier
import app.cash.zipline.loader.ZiplineLoader
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import platform.Foundation.NSURLSession

actual class ComponentBoxController(
    val ziplineMetadata: ZiplineMetadata,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,
    val coroutineScope: CoroutineScope = CoroutineScope(dispatcher),
) {

    private val urlSession = NSURLSession.sharedSession

    val ziplineLoader = ZiplineLoader(
        dispatcher = dispatcher,
        manifestVerifier = ManifestVerifier.NO_SIGNATURE_CHECKS,
        urlSession = urlSession
    )

    actual inline fun <reified Service : ComponentBoxService<Model, State>, Model : ComponentBoxModel<State>, State : ComponentBoxState> model(
        noinline initializer: (Zipline) -> Unit
    ): StateFlow<Model?> = componentBoxModelStateFlow<Service, Model, State>(
        coroutineScope = coroutineScope,
        ziplineLoader = ziplineLoader,
        ziplineMetadata = ziplineMetadata,
        initializer = initializer
    )
}

actual fun componentBoxController(
    ziplineMetadata: ZiplineMetadata,
    dispatcher: CoroutineDispatcher,
    coroutineScope: CoroutineScope
): com.dropbox.componentbox.zipline.ComponentBoxController =
    com.dropbox.componentbox.zipline.ComponentBoxController(ziplineMetadata, dispatcher, coroutineScope)