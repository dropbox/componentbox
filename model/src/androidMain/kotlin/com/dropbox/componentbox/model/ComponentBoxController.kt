package com.dropbox.componentbox.model

import app.cash.zipline.Zipline
import app.cash.zipline.loader.ManifestVerifier
import app.cash.zipline.loader.ZiplineLoader
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import okhttp3.OkHttpClient

actual class ComponentBoxController(
    val serviceCoordinates: ServiceCoordinates,
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
        serviceCoordinates = serviceCoordinates,
        initializer = initializer
    )
}

actual fun componentBoxController(
    serviceCoordinates: ServiceCoordinates,
    dispatcher: CoroutineDispatcher,
    coroutineScope: CoroutineScope
): ComponentBoxController = ComponentBoxController(serviceCoordinates, dispatcher, coroutineScope)