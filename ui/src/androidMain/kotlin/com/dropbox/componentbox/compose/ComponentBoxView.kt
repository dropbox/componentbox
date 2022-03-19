package com.dropbox.componentbox.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.airbnb.mvrx.compose.collectAsState
import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.material.Inflate
import com.dropbox.componentbox.presentation.ComponentBoxPresenter
import com.dropbox.componentbox.presentation.ComponentBoxState
import com.dropbox.componentbox.presentation.ComponentBoxViewModel
import com.dropbox.componentbox.presentation.ComponentBoxViewState

@Composable
inline fun <reified C : ComponentBox, S : ComponentBoxState, V : ComponentBoxViewModel<C>> ComponentBoxView(
    presenter: ComponentBoxPresenter<C, S, V>,
    context: Context,
    noinline Loading: (@Composable () -> Unit)? = null,
    noinline Fallback: (@Composable () -> Unit),
) {
    val viewModel = presenter.models.collectAsState()
    val state = presenter.collectAsState()

    when (val root = viewModel.value.root) {
        null -> when (state.value.viewState) {
            ComponentBoxViewState.Failure -> Fallback()
            ComponentBoxViewState.Initialized -> if (Loading != null) Loading() else ComponentBoxLoadingView()
            ComponentBoxViewState.Loading -> if (Loading != null) Loading() else ComponentBoxLoadingView()
            ComponentBoxViewState.Success -> Fallback()
        }
        else -> root.Inflate(context)
    }
}