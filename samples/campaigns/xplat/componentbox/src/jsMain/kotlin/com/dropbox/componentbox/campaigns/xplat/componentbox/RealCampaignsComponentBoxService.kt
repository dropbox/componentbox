package com.dropbox.componentbox.campaigns.xplat.componentbox

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RealCampaignsComponentBoxService : CampaignsComponentBoxService {
    override fun models(): Flow<CampaignsComponentBoxModel> {
        return flow {
            emit(RealCampaignsComponentBoxModel())
        }
    }
}


