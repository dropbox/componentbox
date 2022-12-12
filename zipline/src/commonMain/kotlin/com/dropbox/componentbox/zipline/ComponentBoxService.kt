package com.dropbox.componentbox.zipline

import app.cash.zipline.ZiplineService
import com.dropbox.componentbox.foundation.ComponentBoxEvent
import kotlinx.coroutines.flow.Flow


interface ComponentBoxService<Model : ComponentBoxModel<State, Event>, State : ComponentBoxState, Event : ComponentBoxEvent> : ZiplineService {
    val componentBoxUrls: Flow<String>
    suspend fun load(manifestUrl: String): Model
}