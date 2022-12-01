package com.dropbox.componentbox.model

import app.cash.zipline.Zipline
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

actual abstract class ComponentBoxPresenter<Data : ComponentBoxData, Model : ComponentBoxModel<Data, State, Event>, State : ComponentBoxState, Event : ComponentBoxEvent> actual constructor(
    initialState: State
) {
    protected val state: MutableStateFlow<State> = MutableStateFlow(initialState)
    protected actual val viewModelScope: CoroutineScope = CoroutineScope(Dispatchers.Main)

    protected actual abstract val serviceName: String
    protected actual abstract val applicationName: String
    protected actual abstract val fetcher: suspend () -> ComponentBoxNetworkResponse<Data>

    protected actual val events: MutableSharedFlow<Event> = MutableSharedFlow()

    actual fun emit(event: Event) {
        viewModelScope.launch {
            events.emit(event)
        }
    }

    protected actual inline fun <reified Service : ComponentBoxService<Model>> launch(
        noinline initializer: (Zipline) -> Unit
    ) {
        viewModelScope.launch {
            val networkResponse = fetcher()
            val controller = ComponentBoxController<Model, State, Event>(
                manifestUrl = networkResponse.manifestUrl,
                serviceName = serviceName,
                applicationName = applicationName
            )
            val models = controller.models<Service>(initializer)
            models.collectLatest { nextModel ->
                nextModel.launch(networkResponse.data, events, viewModelScope)
                    .collectLatest { nextState ->
                        state.value = nextState
                    }
            }
        }
    }
}