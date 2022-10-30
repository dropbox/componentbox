package com.dropbox.componentbox.model

import app.cash.zipline.EventListener
import app.cash.zipline.Zipline
import app.cash.zipline.ZiplineService
import app.cash.zipline.loader.ManifestVerifier
import app.cash.zipline.loader.ZiplineLoader
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import okhttp3.OkHttpClient

class ComponentBoxEventListener : EventListener() {

    override fun bindService(name: String, service: ZiplineService) {
        super.bindService(name, service)
        println("BIND SERVICE ==== $service")
    }
    override fun applicationLoadStart(applicationName: String, manifestUrl: String?): Any? {
        println("APP LOAD START")
        return super.applicationLoadStart(applicationName, manifestUrl)
    }

    override fun manifestParseFailed(applicationName: String, url: String?, exception: Exception) {
        super.manifestParseFailed(applicationName, url, exception)
        println("MANIFEST PARSE FAILED ==== $exception")
    }

    override fun downloadEnd(applicationName: String, url: String, startValue: Any?) {
        println("DOWNLOAD END ===== $url")
        super.downloadEnd(applicationName, url, startValue)
    }

    override fun downloadStart(applicationName: String, url: String): Any? {
        println("DOWNLOAD START ===== $url")
        return super.downloadStart(applicationName, url)
    }

    override fun applicationLoadEnd(
        applicationName: String,
        manifestUrl: String?,
        startValue: Any?
    ) {
        super.applicationLoadEnd(applicationName, manifestUrl, startValue)
        println("APP LOAD END")
    }

    override fun applicationLoadFailed(
        applicationName: String,
        manifestUrl: String?,
        exception: Exception,
        startValue: Any?
    ) {
        super.applicationLoadFailed(applicationName, manifestUrl, exception, startValue)
        println("APP LOAD FAILED ==== $exception")
    }

    override fun downloadFailed(
        applicationName: String,
        url: String,
        exception: Exception,
        startValue: Any?
    ) {
        super.downloadFailed(applicationName, url, exception, startValue)
        println("DOWNLOAD FAILED ===== $exception")
    }

}

actual class ComponentBoxController<Model : ComponentBoxModel<*, State, Event>, State : ComponentBoxState, Event : ComponentBoxEvent>(
    val manifestUrl: String,
    val applicationName: String,
    val serviceName: String
) {
    //    private val ziplineExecutorService = Executors.newSingleThreadExecutor { Thread(it, "Zipline") }
//    val ziplineDispatcher = ziplineExecutorService.asCoroutineDispatcher()
    private val okHttpClient = OkHttpClient()


    val listener = ComponentBoxEventListener()

    val ziplineLoader = ZiplineLoader(
        dispatcher = Dispatchers.Main,
        manifestVerifier = ManifestVerifier.NO_SIGNATURE_CHECKS,
        httpClient = okHttpClient,
        eventListener = listener
    )

    actual inline fun <reified Service : ComponentBoxService<Model>> models(
        noinline initializer: (Zipline) -> Unit
    ): Flow<Model> = flowOfModels<Model, Service>(
        dispatcher = Dispatchers.Main,
        ziplineLoader = ziplineLoader,
        manifestUrl = manifestUrl,
        applicationName = applicationName,
        serviceName = serviceName,
        initializer = initializer
    )
}