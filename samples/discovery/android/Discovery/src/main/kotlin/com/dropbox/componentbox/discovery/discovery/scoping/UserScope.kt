package com.dropbox.componentbox.discovery.discovery.scoping

import com.dropbox.componentbox.discovery.discovery.campaigns.data.CampaignManager
import com.dropbox.componentbox.discovery.discovery.campaigns.data.repository.CampaignRepository
import com.dropbox.componentbox.discovery.discovery.campaigns.data.repository.FakeCampaignRepository

data class UserScope(
    val campaignManager: CampaignManager,
    val campaignRepository: CampaignRepository
)

fun userScope() = UserScope(
    campaignManager = CampaignManager(FakeCampaignRepository()),
    campaignRepository = FakeCampaignRepository()
)