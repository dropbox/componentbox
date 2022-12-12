package com.dropbox.componentbox.zipline

import com.dropbox.componentbox.foundation.ComponentBoxEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class RealComponentBoxStateFlow<Model : ComponentBoxModel<State>, State : ComponentBoxState, Event : ComponentBoxEvent>(
    initialState: State,
    val ziplineMetadataFetcher: suspend () -> ZiplineMetadata,
    val coroutineScope: CoroutineScope,
    val loadingState: State? = null
) {

    val stateFlow = MutableStateFlow(initialState)
    val modelStateFlow = MutableStateFlow<Model?>(null)

    suspend inline fun <reified Service : ComponentBoxService<Model, State>> loadModel() {
        if (loadingState != null) {
            stateFlow.value = loadingState
        }
        val ziplineMetadata = ziplineMetadataFetcher.invoke()
        val componentBoxController = componentBoxController(ziplineMetadata = ziplineMetadata, coroutineScope = coroutineScope)
        modelStateFlow.value = componentBoxController.model<Service, Model, State>().value
    }

    inline fun <reified Service : ComponentBoxService<Model, State>> launch(events: Flow<Event> = flow { }): StateFlow<State> {
        coroutineScope.launch {
            loadModel<Service>()

            modelStateFlow.collect { model ->
                if (model != null) {
                    val state = model.present(events).value
                    stateFlow.value = state
                }
            }
        }

        return stateFlow
    }
}