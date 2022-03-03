package com.dropbox.componentbox.samples.discovery

import app.cash.zipline.FlowReference
import app.cash.zipline.ZiplineService

interface DiscoveryPresenter : ZiplineService {
    suspend fun produceModels(): FlowReference<DiscoveryScreenViewModel>
}