package com.dropbox.componentbox.discovery.zipline

import app.cash.zipline.ZiplineService
import kotlinx.coroutines.flow.Flow

interface ComponentBoxBannerPresenter : ZiplineService {
    suspend fun produceModels(id: String): Flow<ComponentBoxBannerViewModel>
}
