package com.dropbox.componentbox.samples.campaigns.common.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

actual abstract class ViewModel<State : Any, Event : Any>(
    initialState: State,
    coroutineDispatcher: CoroutineDispatcher = Dispatchers.Default,
    protected actual val viewModelScope: CoroutineScope = CoroutineScope(coroutineDispatcher)
) : ViewModel() {
    private val stateFlow = MutableStateFlow(initialState)
    actual val state: StateFlow<State> = stateFlow

    protected actual abstract fun onEvent(event: Event)

    protected fun setState(state: State) {
        stateFlow.value = state
    }

    protected fun withState(block: (state: State) -> Unit) = block(state.value)
}