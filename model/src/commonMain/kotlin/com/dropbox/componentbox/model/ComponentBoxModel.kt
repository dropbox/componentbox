package com.dropbox.componentbox.model

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface ComponentBoxModel<Data : ComponentBoxData, State : ComponentBoxState, Event : ComponentBoxEvent> {
    fun launch(data: Data, events: Flow<Event>, scope: CoroutineScope): StateFlow<State>
}
