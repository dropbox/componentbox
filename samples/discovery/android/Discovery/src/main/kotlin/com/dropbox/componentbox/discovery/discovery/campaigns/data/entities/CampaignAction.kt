package com.dropbox.componentbox.discovery.discovery.campaigns.data.entities

import kotlinx.serialization.Serializable

@Serializable
enum class CampaignAction {
    OpenUpsellScreen,
    OpenFeatureDiscoveryScreen
}