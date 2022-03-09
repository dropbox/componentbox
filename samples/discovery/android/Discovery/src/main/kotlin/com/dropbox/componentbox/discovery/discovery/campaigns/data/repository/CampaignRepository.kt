package com.dropbox.componentbox.discovery.discovery.campaigns.data.repository

import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.BannerStyle
import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.Campaign
import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.CampaignAction

interface CampaignRepository {
    fun getBestCampaigns(): List<Campaign>
}

class FakeCampaignRepository : CampaignRepository {
    override fun getBestCampaigns() = listOf(
        Campaign.Banner.PromptBanner(
            "1",
            "Turn on camera uploads",
            "Keep all your photos safe and sound",
            BannerStyle.Promotion,
            CampaignAction.OpenUpsellScreen,
            iconStart = "CameraUpload.Line",
            iconEnd = "ArrowRight.Line",
        )
    )
}