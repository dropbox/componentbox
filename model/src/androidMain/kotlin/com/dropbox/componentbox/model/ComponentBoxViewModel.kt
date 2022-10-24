package com.dropbox.componentbox.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.StateFlow


class ComponentBoxViewModel<State : ComponentBoxState, Event : ComponentBoxEvent, Model : ComponentBoxModel<State, Event>>(
    initialState: State,
    private val events: MutableSharedFlow<Event>,
    private val controller: ComponentBoxController<Model>
) : ViewModel<State, Event>(initialState = initialState, dispatcher = Dispatchers.Default) {
    internal inline fun <reified Service : ComponentBoxService<Model>> present(): StateFlow<State> =
        present(events, controller.models<Service>())
}