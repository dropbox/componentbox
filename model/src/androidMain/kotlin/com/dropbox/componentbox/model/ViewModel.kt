package com.dropbox.componentbox.model

import androidx.lifecycle.ViewModel
import com.dropbox.componentbox.foundation.ComponentBoxEvent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

abstract class ViewModel<State : ComponentBoxState, Event : ComponentBoxEvent>(
    initialState: State,
    dispatcher: CoroutineDispatcher,
) : ViewModel() {
    private val viewModelScope = CoroutineScope(dispatcher)

    private val stateFlow: MutableStateFlow<State> = MutableStateFlow(initialState)

    protected open fun present(
        events: MutableSharedFlow<Event>,
        models: Flow<ComponentBoxModel<State, Event>>
    ): StateFlow<State> = stateFlow.also {
        viewModelScope.launch {
            models.collectLatest { model ->
                model.launch(events).collectLatest { state ->
                    stateFlow.value = state
                }
            }
        }
    }
}