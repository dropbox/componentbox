package com.dropbox.componentbox.model

import com.dropbox.componentbox.foundation.ComponentBoxEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface ComponentBoxModel<State : ComponentBoxState> {
    fun present(events: Flow<ComponentBoxEvent?>): StateFlow<State>
}