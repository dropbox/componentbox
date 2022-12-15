package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import kotlinx.coroutines.flow.flow

class RealCampaignsComponentBoxService : CampaignsComponentBoxService {
    override fun flowOfComponentBoxUrls() = flow {
        emit("https://api.componentbox.io/samples/campaigns/componentbox/1")
    }

//    override fun loadComponentBoxModel(): Flow<CampaignsComponentBoxModel> = flow { emit(RealCampaignsComponentBoxModel(flowOfComponentBoxUrls())) }
}