package com.dropbox.componentbox.presentation

sealed class ComponentBoxViewState {
    object Initialized: ComponentBoxViewState()
    object Loading : ComponentBoxViewState()
    object Failure : ComponentBoxViewState()
    object Success: ComponentBoxViewState()
}