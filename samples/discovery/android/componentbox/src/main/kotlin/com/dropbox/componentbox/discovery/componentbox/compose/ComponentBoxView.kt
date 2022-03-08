package com.dropbox.componentbox.discovery.componentbox.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
    id: String?,
    noinline CustomLoading: (@Composable () -> Unit)? = null,
    noinline CustomSuccess: (@Composable () -> Unit)? = null,
    noinline CustomFallback: (@Composable () -> Unit)? = null,
) {
    if (id == null) return

    val presenter: ComponentBoxPresenter = mavericksViewModel()

    when (C::class) {
        ComponentBox.Banner::class -> presenter.loadBanner(id)
        ComponentBox.Modal::class -> presenter.loadModal(id)
        ComponentBox.Screen::class -> presenter.loadScreen(id)
    }

    val bannerViewModel = presenter.bannerModels.collectAsState()
    val modalViewModel = presenter.modalsModels.collectAsState()
    val screenViewModel = presenter.screenModels.collectAsState()

    when (presenter.collectAsState().value.viewState) {
        ComponentBoxViewState.Failure -> FailureView<C>(CustomFallback)
        ComponentBoxViewState.Loading -> LoadingView<C>(CustomLoading)
        is ComponentBoxViewState.Success -> when (C::class) {
            ComponentBox.Banner::class -> {
                if (bannerViewModel.value.root != null) SuccessView<C>(bannerViewModel.value, CustomSuccess)
                else LoadingView<C>(CustomLoading)
            }

            ComponentBox.Modal::class -> {
                if (modalViewModel.value.root != null) SuccessView<C>(modalViewModel.value, CustomSuccess)
                else LoadingView<C>(CustomLoading)
            }

            ComponentBox.Screen::class -> {
                if (screenViewModel.value.root != null) SuccessView<C>(screenViewModel.value, CustomSuccess)
                else LoadingView<C>(CustomLoading)
            }
        }
    }
}
