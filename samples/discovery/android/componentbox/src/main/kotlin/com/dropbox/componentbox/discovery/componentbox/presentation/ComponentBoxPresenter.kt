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

    fun loadBanner(id: String) {
        val models = MutableStateFlow(ComponentBoxBannerViewModel())
        val scope = MainScope()
        zipline.produceModelsInBanner(id, scope, models)
        setState {
            ComponentBoxState(ComponentBoxViewState.Success(models.value))
        }
    }

    fun loadModal(id: String) {
        val models = MutableStateFlow(ComponentBoxModalViewModel())
        val scope = MainScope()
        zipline.produceModelsInModal(id, scope, models)
        setState {
            ComponentBoxState(ComponentBoxViewState.Success(models.value))
        }
    }

    fun loadScreen(id: String) {
        val models = MutableStateFlow(ComponentBoxScreenViewModel())
        val scope = MainScope()
        zipline.produceModelsInScreen(id, scope, models)
        setState {
            ComponentBoxState(ComponentBoxViewState.Success(models.value))
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
