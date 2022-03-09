package com.dropbox.componentbox.discovery.discovery.util

import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.Campaign

fun Campaign?.id() = when (this) {
    is Campaign.Banner.ComponentBoxBanner -> promptCampaign.id
    is Campaign.Banner.PromptBanner -> id
    is Campaign.Modal.ComponentBox -> promptCampaign.id
    is Campaign.Modal.PromptModal -> id
    is Campaign.UpgradeScreen.ComponentBoxUpgradeScreen -> promptCampaign.id
    is Campaign.UpgradeScreen.PromptUpgradeScreen -> id
    null -> null
}

fun Campaign?.componentBoxId() = when (this) {
    is Campaign.Banner.ComponentBoxBanner -> componentBoxId
    is Campaign.Modal.ComponentBox -> componentBoxId
    is Campaign.UpgradeScreen.ComponentBoxUpgradeScreen -> componentBoxId
    else -> null
}