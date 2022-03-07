package com.dropbox.componentbox.discovery.zipline

import app.cash.zipline.ZiplineService
import kotlinx.coroutines.flow.Flow

interface ComponentBoxScreenPresenter : ZiplineService {
    suspend fun produceModels(id: String): Flow<ComponentBoxScreenViewModel>
}