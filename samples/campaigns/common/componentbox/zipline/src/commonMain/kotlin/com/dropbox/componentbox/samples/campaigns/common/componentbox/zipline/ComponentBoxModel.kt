package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import com.dropbox.componentbox.foundation.ComponentBoxEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface ComponentBoxModel<State : ComponentBoxState, Event : ComponentBoxEvent> {
    fun present(events: Flow<Event?>): StateFlow<State>
}