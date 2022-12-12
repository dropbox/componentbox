package com.dropbox.componentbox.zipline

import app.cash.zipline.Zipline
import com.dropbox.componentbox.foundation.ComponentBoxEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class RealComponentBoxStateFlow<Model : ComponentBoxModel<State, Event>, State : ComponentBoxState, Event : ComponentBoxEvent>(
    initialState: State,
    val ziplineMetadataFetcher: suspend () -> ZiplineMetadata,
    val ziplineInitializer: (zipline: Zipline) -> Unit,
    val coroutineScope: CoroutineScope,
    val loadingState: State? = null
) {

    val stateFlow = MutableStateFlow(initialState)
    val modelStateFlow = MutableStateFlow<Model?>(null)

    suspend inline fun <reified Service : ComponentBoxService<Model, State, Event>> loadModel() {
        if (loadingState != null) {
            stateFlow.value = loadingState
        }
        val ziplineMetadata = ziplineMetadataFetcher.invoke()
        val componentBoxController = componentBoxController(ziplineMetadata = ziplineMetadata, coroutineScope = coroutineScope)
        modelStateFlow.value = componentBoxController.model<Service, Model, State, Event>(ziplineInitializer).value
    }

    inline fun <reified Service : ComponentBoxService<Model, State, Event>> launch(events: Flow<Event> = flow { }): StateFlow<State> {
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