package com.dropbox.componentbox.discovery.componentbox.compose

import androidx.compose.runtime.Composable
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.dropbox.common.componentbox.ui.compose.generic.LoadingView
import com.dropbox.componentbox.discovery.componentbox.compose.generic.FailureView
import com.dropbox.componentbox.discovery.componentbox.compose.generic.SuccessView
import com.dropbox.componentbox.discovery.componentbox.presentation.ComponentBoxPresenter
import com.dropbox.componentbox.discovery.componentbox.presentation.ComponentBoxViewState
import com.dropbox.componentbox.models.ComponentBox

@Composable
inline fun <reified C : ComponentBox> ComponentBoxView(
    id: String,
    noinline CustomLoading: (@Composable () -> Unit)? = null,
    noinline CustomSuccess: (@Composable () -> Unit)? = null,
    noinline CustomFallback: (@Composable () -> Unit)? = null,
) {
    val presenter: ComponentBoxPresenter = mavericksViewModel()

    when (C::class) {
        ComponentBox.Banner::class -> presenter.loadBanner(id)
        ComponentBox.Modal::class -> presenter.loadModal(id)
        ComponentBox.Screen::class -> presenter.loadScreen(id)
    }

    when (val state = presenter.collectAsState().value.viewState) {
        ComponentBoxViewState.Failure -> FailureView<C>(CustomFallback)
        ComponentBoxViewState.Loading -> LoadingView<C>(CustomLoading)
        is ComponentBoxViewState.Success<*> -> SuccessView<C>(state.viewModel, CustomSuccess)
    }
}
