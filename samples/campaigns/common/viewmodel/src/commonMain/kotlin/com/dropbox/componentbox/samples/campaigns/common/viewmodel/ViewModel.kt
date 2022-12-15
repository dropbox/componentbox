package com.dropbox.componentbox.samples.campaigns.common.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.StateFlow

expect abstract class ViewModel<State : Any, Event : Any> {
    val state: StateFlow<State>
    protected val viewModelScope: CoroutineScope
    protected abstract fun onEvent(event: Event)
    protected fun setState(state: State)
    protected fun withState(block: (state: State) -> Unit)
}