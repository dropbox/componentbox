package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import kotlinx.coroutines.flow.flow

class RealCampaignsComponentBoxService : CampaignsComponentBoxService {
    override val componentBoxUrls = flow {
        emit("https://api.componentbox.io/samples/campaigns/componentbox/1")
    }

    override suspend fun load(): CampaignsComponentBoxModel = RealCampaignsComponentBoxModel(componentBoxUrls)
}