package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import app.cash.zipline.Zipline
import app.cash.zipline.loader.ManifestVerifier
import app.cash.zipline.loader.ZiplineLoader
import com.dropbox.componentbox.foundation.ComponentBoxEvent
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

    actual inline fun <reified Service : ComponentBoxService<Model, State, Event>, Model : ComponentBoxModel<State, Event>, State : ComponentBoxState, Event : ComponentBoxEvent> model(
        noinline ziplineInitializer: (Zipline) -> Unit
    ): StateFlow<Model?> = componentBoxModelStateFlow<Service, Model, State, Event>(
        coroutineScope = coroutineScope,
        ziplineLoader = ziplineLoader,
        ziplineMetadata = ziplineMetadata,
        ziplineInitializer = ziplineInitializer
    )
}

actual fun componentBoxController(
    ziplineMetadata: ZiplineMetadata,
    dispatcher: CoroutineDispatcher,
    coroutineScope: CoroutineScope
): ComponentBoxController = ComponentBoxController(ziplineMetadata, dispatcher, coroutineScope)