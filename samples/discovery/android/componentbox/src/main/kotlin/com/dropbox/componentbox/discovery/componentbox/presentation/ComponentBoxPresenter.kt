@file:Suppress("UNCHECKED_CAST")

package com.dropbox.componentbox.discovery.componentbox.presentation

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.dropbox.componentbox.discovery.zipline.ComponentBoxBannerViewModel
import com.dropbox.componentbox.discovery.zipline.ComponentBoxModalViewModel
import com.dropbox.componentbox.discovery.zipline.ComponentBoxScreenViewModel
import com.dropbox.componentbox.discovery.zipline.ComponentBoxZipline
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableStateFlow

class ComponentBoxPresenter(
    initialState: ComponentBoxState,
    private val zipline: ComponentBoxZipline,
) : MavericksViewModel<ComponentBoxState>(initialState) {
    val bannerModels = MutableStateFlow(ComponentBoxBannerViewModel())
    val modalsModels = MutableStateFlow(ComponentBoxModalViewModel())
    val screenModels = MutableStateFlow(ComponentBoxScreenViewModel())

    fun loadBanner(id: String) {
        val scope = MainScope()
        zipline.produceModelsInBanner(id, scope, bannerModels)
        setState {
            ComponentBoxState(ComponentBoxViewState.Success)
        }
    }

    fun loadModal(id: String) {
        val scope = MainScope()
        zipline.produceModelsInModal(id, scope, modalsModels)
        setState {
            ComponentBoxState(ComponentBoxViewState.Success)
        }
    }

    fun loadScreen(id: String) {
        val scope = MainScope()
        zipline.produceModelsInScreen(id, scope, screenModels)
        setState {
            ComponentBoxState(ComponentBoxViewState.Success)
        }
    }

    companion object : MavericksViewModelFactory<ComponentBoxPresenter, ComponentBoxState> {
        override fun initialState(viewModelContext: ViewModelContext): ComponentBoxState? {
            return ComponentBoxState(ComponentBoxViewState.Loading)
        }

        override fun create(viewModelContext: ViewModelContext, state: ComponentBoxState): ComponentBoxPresenter? {
            return ComponentBoxPresenter(state, ComponentBoxZipline())
        }
    }
}
