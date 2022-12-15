package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import app.cash.zipline.ZiplineService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface CampaignsComponentBoxModel : ZiplineService {
    fun present(events: Flow<CampaignsComponentBoxEvent>): StateFlow<CampaignsComponentBoxState>
}