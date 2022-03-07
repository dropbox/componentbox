package com.dropbox.componentbox.discovery.componentbox.presentation

sealed class ComponentBoxViewState {
    object Loading : ComponentBoxViewState()
    object Failure : ComponentBoxViewState()
    data class Success<P>(
        val viewModel: P
    ) : ComponentBoxViewState()
}
