package com.dropbox.componentbox.ui

import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.viewmodel.ComponentBoxViewState
import kotlinx.coroutines.flow.Flow


interface ComponentBoxController {
    fun start(
        viewState: ComponentBoxViewState,
        events: Flow<ComponentBox.Event>,
        navigation: Flow<ComponentBox.Navigation>
    )
}