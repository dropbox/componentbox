package com.dropbox.componentbox.viewmodel

import app.cash.zipline.Zipline
import app.cash.zipline.loader.ZiplineLoader
import com.dropbox.componentbox.ComponentBox
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch


const val COMPONENT_BOX_PRESENTER = "ComponentBox.Presenter"
const val COMPONENT_BOX = "ComponentBox"

fun launchComponentBoxZipline(
    scope: CoroutineScope,
    ziplineDispatcher: CoroutineDispatcher,
    ziplineLoader: ZiplineLoader,
    manifestUrl: String,
    data: Flow<ComponentBox>,
    events: Flow<ComponentBox.Event>,
    navigation: Flow<ComponentBox.Navigation>,
    componentBox: MutableStateFlow<ZiplineResponse>
) {

    scope.launch(ziplineDispatcher + SupervisorJob()) {
        val loadedZipline = ziplineLoader.loadOnce(
            applicationName = COMPONENT_BOX,
            manifestUrl = manifestUrl
        )

        componentBoxZipline(
            zipline = loadedZipline.zipline,
            data = data,
            events = events,
            navigation = navigation,
            componentBox = componentBox
        )
    }
}


private fun CoroutineScope.componentBoxZipline(
    zipline: Zipline,
    events: Flow<ComponentBox.Event>,
    navigation: Flow<ComponentBox.Navigation>,
    data: Flow<ComponentBox>,
    componentBox: MutableStateFlow<ZiplineResponse>
) {
    launch {
        val presenter = zipline.take<ComponentBoxPresenter>(COMPONENT_BOX_PRESENTER)
        val job = launch {
            componentBox.emitAll(presenter.componentBox(data, events))
            presenter.navigate(navigation)
        }
        job.invokeOnCompletion {
            presenter.close()
        }
    }
}