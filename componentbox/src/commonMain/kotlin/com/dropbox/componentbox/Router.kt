package com.dropbox.componentbox

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class Router(
    private val routes: Map<String, Component>,
    start: String
) {
    private val stateFlow = MutableStateFlow(requireNotNull(routes[start]))
    val component: StateFlow<Component> = stateFlow

    fun navigateTo(next: String) {
        stateFlow.value = requireNotNull(routes[next])
    }
}