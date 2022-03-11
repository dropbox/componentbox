package com.dropbox.componentbox.zipline

import app.cash.zipline.ZiplineService
import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.foundation.ComponentBoxType
import com.dropbox.componentbox.presentation.ComponentBoxViewModel
import kotlinx.coroutines.flow.Flow

interface ComponentBoxZiplineService : ZiplineService {
    suspend fun <C : ComponentBox> produceModels(type: ComponentBoxType, url: String, headers: Map<String, String> = mapOf()): Flow<ComponentBoxViewModel<C>>
}