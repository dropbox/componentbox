package com.dropbox.componentbox.discovery.componentbox.presentation

import com.airbnb.mvrx.MavericksState

data class ComponentBoxState(
    val viewState: ComponentBoxViewState,
) : MavericksState
