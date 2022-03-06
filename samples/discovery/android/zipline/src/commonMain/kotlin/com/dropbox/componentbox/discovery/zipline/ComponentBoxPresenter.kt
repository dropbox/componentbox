package com.dropbox.componentbox.discovery.zipline

import app.cash.zipline.ZiplineService
import com.dropbox.componentbox.models.ComponentBox
import com.dropbox.componentbox.models.ComponentBoxType
import kotlinx.coroutines.flow.Flow

interface ComponentBoxPresenter<C : ComponentBox> : ZiplineService {
    suspend fun produceModels(id: String, type: ComponentBoxType?): Flow<ComponentBoxViewModel<C>>
}
