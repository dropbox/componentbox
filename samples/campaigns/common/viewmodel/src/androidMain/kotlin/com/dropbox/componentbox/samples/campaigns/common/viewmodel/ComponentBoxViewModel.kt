package com.dropbox.componentbox.samples.campaigns.common.viewmodel

import app.cash.zipline.Zipline
import com.dropbox.componentbox.foundation.ComponentBoxEvent
import com.dropbox.componentbox.zipline.ComponentBoxModel
import com.dropbox.componentbox.zipline.ComponentBoxService
import com.dropbox.componentbox.zipline.ComponentBoxState
import com.dropbox.componentbox.zipline.ComponentBoxStateFlow
import com.dropbox.componentbox.zipline.ZiplineMetadata
import kotlinx.coroutines.flow.StateFlow

actual abstract class ComponentBoxViewModel<State : ComponentBoxState, Event : ComponentBoxEvent>(initialState: State) : ViewModel<State, Event>(initialState) {
    protected actual abstract suspend fun fetchZiplineMetadata(): ZiplineMetadata

    open fun initializeZipline(zipline: Zipline) {}

    protected actual inline fun <reified Service : ComponentBoxService<Model, State, Event>, Model : ComponentBoxModel<State, Event>> componentBoxStateFlowOf(
        initialState: State
    ): StateFlow<ComponentBoxState> = ComponentBoxStateFlow<Service, Model, State, Event>(initialState, ::fetchZiplineMetadata, ::initializeZipline)
}