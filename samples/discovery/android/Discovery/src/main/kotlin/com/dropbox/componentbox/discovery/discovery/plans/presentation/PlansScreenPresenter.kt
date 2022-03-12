package com.dropbox.componentbox.discovery.discovery.plans.presentation

import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.dropbox.componentbox.discovery.discovery.RealComponentBoxPresenter
import com.dropbox.componentbox.discovery.zipline.LOAD_COMPONENT_BOX_SCRIPT
import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.presentation.ComponentBoxPresenter
import com.dropbox.componentbox.presentation.ComponentBoxState
import com.dropbox.componentbox.presentation.ComponentBoxViewModel
import com.dropbox.componentbox.presentation.ComponentBoxViewState
import com.dropbox.componentbox.presentation.RealComponentBoxState
import com.dropbox.componentbox.zipline.ComponentBoxZipline

class PlansScreenPresenter(zipline: ComponentBoxZipline, componentBoxUrl: String, initialState: ComponentBoxState) :
    MavericksViewModel<ComponentBoxState>(initialState) {
    private val componentBoxPresenter: ComponentBoxPresenter<ComponentBox.Screen, ComponentBoxState, ComponentBoxViewModel<ComponentBox.Screen>>

    init {
        componentBoxPresenter = RealComponentBoxPresenter(zipline, componentBoxUrl)
    }

    fun bridge() = componentBoxPresenter

    companion object : MavericksViewModelFactory<PlansScreenPresenter, ComponentBoxState> {
        override fun initialState(viewModelContext: ViewModelContext): ComponentBoxState {
            return RealComponentBoxState(ComponentBoxViewState.Initialized)
        }

        override fun create(viewModelContext: ViewModelContext, state: ComponentBoxState): PlansScreenPresenter? {

            val ziplineUrl = "https://api.componentbox.io/zipline/1.js"
            val componentBoxUrl = "https://api.componentbox.io/screens/1.json"
            val zipline = ComponentBoxZipline(ziplineUrl = ziplineUrl, script = LOAD_COMPONENT_BOX_SCRIPT)
            return PlansScreenPresenter(
                zipline,
                componentBoxUrl,
                RealComponentBoxState(ComponentBoxViewState.Initialized)
            )
        }
    }
}