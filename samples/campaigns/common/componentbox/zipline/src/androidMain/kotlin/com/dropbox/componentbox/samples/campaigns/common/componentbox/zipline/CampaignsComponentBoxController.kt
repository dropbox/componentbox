package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import app.cash.zipline.Call
import app.cash.zipline.CallResult
import app.cash.zipline.EventListener
import app.cash.zipline.Zipline
import app.cash.zipline.loader.ManifestVerifier
import app.cash.zipline.loader.ZiplineLoader
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.StateFlow
import okhttp3.OkHttpClient


class DbxEventListener : EventListener() {
    override fun callStart(zipline: Zipline, call: Call): Any? {
        println("CALL START === $zipline")
        return super.callStart(zipline, call)
    }

    override fun downloadEnd(applicationName: String, url: String, startValue: Any?) {
        println("DOWNLOAD END ==== $url")
        super.downloadEnd(applicationName, url, startValue)
    }

    override fun downloadFailed(applicationName: String, url: String, exception: Exception, startValue: Any?) {
        println("DOWNLOAD FAILED ==== $exception")
        super.downloadFailed(applicationName, url, exception, startValue)
    }

    override fun downloadStart(applicationName: String, url: String): Any? {
        println("DOWNLOAD START ==== $applicationName --- $url")
        return super.downloadStart(applicationName, url)
    }

    override fun callEnd(zipline: Zipline, call: Call, result: CallResult, startValue: Any?) {
        println("CALL END ==== $zipline --- $call --- $result")
        super.callEnd(zipline, call, result, startValue)
    }

    override fun manifestParseFailed(applicationName: String, url: String?, exception: Exception) {
        println("MANIFEST PARSE FAILED ==== $url --- $exception")
        super.manifestParseFailed(applicationName, url, exception)
    }

    override fun applicationLoadFailed(applicationName: String, manifestUrl: String?, exception: Exception, startValue: Any?) {
        println("APPLICATION LOAD FAILED ==== $manifestUrl --- $exception")
        super.applicationLoadFailed(applicationName, manifestUrl, exception, startValue)
    }

    override fun applicationLoadSuccess(applicationName: String, manifestUrl: String?, zipline: Zipline, startValue: Any?) {
        println("APPLICATION LOAD SUCCESS ==== $manifestUrl")
        super.applicationLoadSuccess(applicationName, manifestUrl, zipline, startValue)
    }
}


actual class CampaignsComponentBoxController(
    private val ziplineMetadata: ZiplineMetadata,
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default,
    private val coroutineScope: CoroutineScope = CoroutineScope(coroutineDispatcher)
) {


    private val okHttpClient = OkHttpClient()

    private val listener = DbxEventListener()

    private val ziplineLoader = ZiplineLoader(
        dispatcher = coroutineDispatcher,
        manifestVerifier = ManifestVerifier.NO_SIGNATURE_CHECKS,
        httpClient = okHttpClient,
        eventListener = listener
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