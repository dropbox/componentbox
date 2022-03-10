package com.dropbox.componentbox.discovery.discovery.campaigns.data

import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.CampaignAction

fun CampaignAction.run(): () -> Unit = when (this) {
    CampaignAction.OpenUpsellScreen -> {
        {}
    }
    CampaignAction.OpenFeatureDiscoveryScreen -> {
        {}
    }
}