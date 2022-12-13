package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import app.cash.zipline.Zipline
import app.cash.zipline.loader.ManifestVerifier
import app.cash.zipline.loader.ZiplineLoader
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import okhttp3.OkHttpClient

actual class CampaignsComponentBoxController(
    private val ziplineMetadata: ZiplineMetadata,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val coroutineScope: CoroutineScope = CoroutineScope(coroutineDispatcher)
) {
    private val okHttpClient = OkHttpClient()

    private val ziplineLoader = ZiplineLoader(
        dispatcher = coroutineDispatcher,
        manifestVerifier = ManifestVerifier.NO_SIGNATURE_CHECKS,
        httpClient = okHttpClient
    )

    actual fun models(ziplineInitializer: (Zipline) -> Unit): StateFlow<CampaignsComponentBoxModel?> = campaignsComponentBoxModelStateFlow(
        coroutineScope = coroutineScope,
        ziplineLoader = ziplineLoader,
        ziplineMetadata = ziplineMetadata,
        ziplineInitializer = ziplineInitializer
    )
}

actual fun campaignsComponentBoxControllerOf(
    ziplineMetadata: ZiplineMetadata,
    coroutineDispatcher: CoroutineDispatcher,
    coroutineScope: CoroutineScope
): CampaignsComponentBoxController = CampaignsComponentBoxController(ziplineMetadata, coroutineDispatcher, coroutineScope)