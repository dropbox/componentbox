package com.dropbox.componentbox.model

import com.dropbox.componentbox.foundation.ComponentBoxEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

interface ComponentBoxModel<State : ComponentBoxState, Event : ComponentBoxEvent> {
    fun launch(events: MutableSharedFlow<Event>): MutableStateFlow<State>
}
