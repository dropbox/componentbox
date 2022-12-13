package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface CampaignsComponentBoxModel {
    fun present(events: Flow<CampaignsComponentBoxEvent?>): StateFlow<CampaignsComponentBoxState>
}