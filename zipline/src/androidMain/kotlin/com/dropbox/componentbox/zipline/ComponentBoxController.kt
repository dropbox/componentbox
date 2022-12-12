package com.dropbox.componentbox.zipline

import app.cash.zipline.Zipline
import app.cash.zipline.loader.ManifestVerifier
import app.cash.zipline.loader.ZiplineLoader
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import okhttp3.OkHttpClient

actual class ComponentBoxController(
    val ziplineMetadata: ZiplineMetadata,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default,
    val coroutineScope: CoroutineScope = CoroutineScope(coroutineDispatcher),
) {

    private val okHttpClient = OkHttpClient()

    val ziplineLoader = ZiplineLoader(
        dispatcher = coroutineDispatcher,
        manifestVerifier = ManifestVerifier.NO_SIGNATURE_CHECKS,
        httpClient = okHttpClient
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
): ComponentBoxController = ComponentBoxController(ziplineMetadata, dispatcher, coroutineScope)