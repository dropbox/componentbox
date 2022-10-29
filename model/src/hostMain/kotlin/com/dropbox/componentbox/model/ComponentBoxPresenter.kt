package com.dropbox.componentbox.model

import app.cash.zipline.Zipline
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow

expect abstract class ComponentBoxPresenter<Data : ComponentBoxData, Model : ComponentBoxModel<Data, State, Event>, State : ComponentBoxState, Event : ComponentBoxEvent>(
    initialState: State,
) {

    protected val viewModelScope: CoroutineScope
    protected abstract val serviceName: String
    protected abstract val applicationName: String
    protected abstract val fetcher: suspend () -> ComponentBoxNetworkResponse<Data>

    protected val events: MutableSharedFlow<Event>

    fun emit(event: Event)

    protected inline fun <reified Service : ComponentBoxService<Model>> launch(
        noinline initializer: (Zipline) -> Unit = {}
    )
}