package com.dropbox.componentbox.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import com.dropbox.componentbox.foundation.ComponentBoxEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow

@Composable
inline fun <reified Service : ComponentBoxService<Model, State>, Model : ComponentBoxModel<State>, State : ComponentBoxState, Event : ComponentBoxEvent> ComponentBoxStateFlow(
    initialState: State,
    noinline serviceCoordinatesFetcher: suspend () -> ServiceCoordinates,
    key: Any? = null,
    events: Flow<Event> = flow { },
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    loadingState: State? = null,
): StateFlow<State> {
    val stateFlow = MutableStateFlow(initialState)

    val modelStateFlow = MutableStateFlow<Model?>(null)

    LaunchedEffect(key) {
        if (loadingState != null) {
            stateFlow.value = loadingState
        }
        val coordinates = serviceCoordinatesFetcher.invoke()
        val controller = componentBoxController(serviceCoordinates = coordinates, coroutineScope = coroutineScope)
        modelStateFlow.value = controller.model<Service, Model, State>().value
    }

    val model = modelStateFlow.collectAsState().value

    if (model != null) {
        stateFlow.value = modelStateFlow.value!!.present(events).value
    }

    return stateFlow
}
