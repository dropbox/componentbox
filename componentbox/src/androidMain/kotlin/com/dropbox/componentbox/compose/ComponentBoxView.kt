package com.dropbox.componentbox.compose

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.material.Inflate
import com.dropbox.componentbox.presentation.ComponentBoxPresenter
import com.dropbox.componentbox.presentation.ComponentBoxState
import com.dropbox.componentbox.presentation.ComponentBoxViewModel

@Composable
inline fun <reified C : ComponentBox, S : ComponentBoxState, V : ComponentBoxViewModel<C>> ComponentBoxView(
    presenter: ComponentBoxPresenter<C, S, V>,
    context: Context,
    noinline Loading: (@Composable () -> Unit),
    noinline Fallback: (@Composable () -> Unit),
) {
    val viewModel = presenter.models.collectAsState()

    when (val root = viewModel.value.root) {
        null -> Text("Loading")
        else -> root.Inflate(context)
    }

    // when (presenter.collectAsState().value.viewState) {
    //     ComponentBoxViewState.Failure -> Fallback()
    //     ComponentBoxViewState.Initialized -> {
    //         Text("Initialized ")
    //     }
    //     ComponentBoxViewState.Loading -> {
    //         Text("Loading")
    //     }
    //     ComponentBoxViewState.Success -> when (val root = viewModel.value.root) {
    //         null -> Loading()
    //         else -> root.Inflate(context)
    //     }
    // }
}