package com.dropbox.componentbox.discovery.discovery.campaigns.data.repository

import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.BannerStyle
import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.Campaign
import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.CampaignAction
import com.dropbox.componentbox.discovery.theme.R

interface CampaignRepository {
    fun getBestCampaigns(): List<Campaign>
}

class FakeCampaignRepository : CampaignRepository {
    override fun getBestCampaigns(): List<Campaign> = listOf(

        Campaign.Banner.PromptBanner(
            "1",
            "Turn on camera uploads",
            "Keep all your photos safe and sound",
            BannerStyle.Promotion,
            CampaignAction.OpenUpsellScreen,
            iconStart = "CameraUpload.Line",
            iconEnd = "ArrowRight.Line",
        ),

        Campaign.Modal.PromptModal(
            "2",
            "https://raw.githubusercontent.com/dropbox/componentbox/master/samples/discovery/theme/src/main/res/drawable-xhdpi/traffic_road_blocked.webp",
            "Keep your photos safe",
            "Now you can auto-upload right from your phone to view and share on any device",
            CampaignAction.OpenUpsellScreen,
            "Show me how",
            "Dismiss"
        )
    )
}