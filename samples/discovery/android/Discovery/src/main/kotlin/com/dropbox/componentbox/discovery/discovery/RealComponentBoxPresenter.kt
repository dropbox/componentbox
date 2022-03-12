package com.dropbox.componentbox.discovery.discovery

import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.foundation.ComponentBoxType
import com.dropbox.componentbox.presentation.ComponentBoxPresenter
import com.dropbox.componentbox.presentation.ComponentBoxState
import com.dropbox.componentbox.presentation.ComponentBoxViewModel
import com.dropbox.componentbox.presentation.ComponentBoxViewState
import com.dropbox.componentbox.presentation.RealComponentBoxState
import com.dropbox.componentbox.zipline.ComponentBoxZipline

class RealComponentBoxPresenter(zipline: ComponentBoxZipline, componentBoxUrl: String) :
    ComponentBoxPresenter<ComponentBox.Screen, ComponentBoxState, ComponentBoxViewModel<ComponentBox.Screen>>(
        initialState = RealComponentBoxState(ComponentBoxViewState.Initialized),
        viewModel = ComponentBoxViewModel(),
        zipline = zipline,
        type = ComponentBoxType.Screen,
        componentBoxUrl = componentBoxUrl
    )