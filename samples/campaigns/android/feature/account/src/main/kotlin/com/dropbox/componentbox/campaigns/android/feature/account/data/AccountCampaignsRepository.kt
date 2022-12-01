package com.dropbox.componentbox.campaigns.android.feature.account.data

import com.dropbox.componentbox.campaigns.xplat.componentbox.CampaignsComponentBoxData

interface AccountCampaignsRepository {
    suspend fun getBestCampaign(): Campaign<CampaignsComponentBoxData>
}
