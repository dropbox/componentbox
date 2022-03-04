package com.dropbox.componentbox.samples.discovery

import app.cash.zipline.ZiplineService
import kotlinx.coroutines.flow.Flow

interface DiscoveryPresenter : ZiplineService {
    suspend fun produceModels(): Flow<DiscoveryScreenViewModel>
}