package com.dropbox.componentbox.model

import app.cash.zipline.Zipline
import com.airbnb.mvrx.MavericksViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

actual abstract class ComponentBoxPresenter<Data : ComponentBoxData, Model : ComponentBoxModel<Data, State, Event>, State : ComponentBoxState, Event : ComponentBoxEvent> actual constructor(
    initialState: State
) : MavericksViewModel<State>(initialState) {

    actual abstract val serviceName: String
    actual abstract val applicationName: String
    actual abstract val fetcher: suspend () -> ComponentBoxNetworkResponse<Data>

    actual val events: MutableSharedFlow<Event> = MutableSharedFlow()

    actual fun emit(event: Event) {
        viewModelScope.launch {
            events.emit(event)
        }
    }

    @PublishedApi
    internal fun setState(nextState: State) {
        setState { nextState }
    }

    actual inline fun <reified Service : ComponentBoxService<Model>> launch(
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
            models.collectLatest { model ->
                model.launch(networkResponse.data, events, viewModelScope).collectLatest { state ->
                    setState(state)
                }
            }
        }
    }
}