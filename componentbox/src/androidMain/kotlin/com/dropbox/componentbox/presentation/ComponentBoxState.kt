package com.dropbox.componentbox.presentation

import com.airbnb.mvrx.MavericksState

interface ComponentBoxState : MavericksState {
    val viewState: ComponentBoxViewState
}

data class RealComponentBoxState(
    override val viewState: ComponentBoxViewState
) : ComponentBoxState