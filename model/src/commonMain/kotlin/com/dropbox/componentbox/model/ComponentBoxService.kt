package com.dropbox.componentbox.model

import app.cash.zipline.ZiplineService
import kotlinx.coroutines.flow.Flow

interface ComponentBoxService<Model : ComponentBoxModel<*, *, *>> : ZiplineService {
    fun models(): Flow<Model>
}