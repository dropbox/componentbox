package com.dropbox.componentbox.discovery.discovery.plans.presentation

import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.presentation.*
import com.dropbox.componentbox.zipline.ComponentBoxZipline

class PlansScreenPresenter(zipline: ComponentBoxZipline) :
    ComponentBoxPresenter<ComponentBox.Screen, ComponentBoxState, ComponentBoxViewModel<ComponentBox.Screen>>(
        initialState = RealComponentBoxState(ComponentBoxViewState.Loading),
        viewModel = ComponentBoxViewModel(),
        zipline = zipline
    )