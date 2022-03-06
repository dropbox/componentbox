package com.dropbox.componentbox.discovery.componentbox.presentation

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.dropbox.componentbox.models.ComponentBox
import com.dropbox.componentbox.discovery.zipline.ComponentBoxViewModel
import com.dropbox.componentbox.discovery.zipline.ComponentBoxZipline
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableStateFlow

class ComponentBoxPresenter(
    initialState: ComponentBoxState,
    val zipline: ComponentBoxZipline,
) : MavericksViewModel<ComponentBoxState>(initialState) {

    inline fun <reified C : ComponentBox> load(id: String) {
        val models = MutableStateFlow(ComponentBoxViewModel<C>())
        val scope = MainScope()
        zipline.load(id, scope, models)
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
