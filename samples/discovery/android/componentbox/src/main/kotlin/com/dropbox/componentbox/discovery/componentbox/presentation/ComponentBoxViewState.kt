package com.dropbox.componentbox.discovery.componentbox.presentation

import com.dropbox.componentbox.models.ComponentBox
import com.dropbox.componentbox.samples.discovery.ComponentBoxViewModel

sealed class ComponentBoxViewState {
    object Loading : ComponentBoxViewState()
    object Failure : ComponentBoxViewState()
    data class Success<C : ComponentBox>(
        val viewModel: ComponentBoxViewModel<C>
    ) : ComponentBoxViewState()
}
