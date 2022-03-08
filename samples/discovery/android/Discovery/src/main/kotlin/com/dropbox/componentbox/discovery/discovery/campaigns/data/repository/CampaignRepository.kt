package com.dropbox.componentbox.discovery.discovery.campaigns.data.repository

import com.dropbox.componentbox.discovery.discovery.campaigns.data.BannerStyle
import com.dropbox.componentbox.discovery.discovery.campaigns.data.Campaign
import com.dropbox.componentbox.discovery.discovery.campaigns.data.CampaignAction

interface CampaignRepository {
    fun getBestCampaigns(): List<Campaign>
}

class FakeCampaignRepository : CampaignRepository {
    override fun getBestCampaigns() = listOf(
        Campaign.Banner(
            "1",
            "",
            "",
            BannerStyle.Promotion,
            CampaignAction.OpenUpsellScreen,
            iconStart = "Info.Line",
            iconEnd = "Close.Line",
            componentBoxId = "1"
        )
    )
}