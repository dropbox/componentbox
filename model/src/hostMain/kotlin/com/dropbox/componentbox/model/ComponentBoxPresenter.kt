package com.dropbox.componentbox.model

import app.cash.zipline.Zipline
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow

expect abstract class ComponentBoxPresenter<Data : ComponentBoxData, Model : ComponentBoxModel<Data, State, Event>, State : ComponentBoxState, Event : ComponentBoxEvent>(
    initialState: State,
) {

    val viewModelScope: CoroutineScope
    abstract val serviceName: String
    abstract val applicationName: String
    abstract val fetcher: suspend () -> ComponentBoxNetworkResponse<Data>

    protected val events: MutableSharedFlow<Event>

    fun emit(event: Event)

    inline fun <reified Service : ComponentBoxService<Model>> launch(
        noinline initializer: (Zipline) -> Unit = {}
    )
}