package com.dropbox.componentbox.model

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Represents a stateful unidirectional data flow model.
 * @param initialState The initial state of the model.
 */
abstract class ComposableModel<State : Any, Event : Any>(
    initialState: State
) {
    private val stateFlow: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state: StateFlow<State> = stateFlow

    fun setState(next: State) {
        stateFlow.value = next
    }

    fun withState(block: (state: State) -> Unit) {
        block(stateFlow.value)
    }

    abstract fun on(event: Event)
}