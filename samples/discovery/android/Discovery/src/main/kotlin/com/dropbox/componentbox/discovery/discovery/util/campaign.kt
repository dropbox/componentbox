package com.dropbox.componentbox.discovery.discovery.util

import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.Campaign

fun Campaign?.id() = when (this) {
    is Campaign.Banner.ComponentBoxBanner -> promptCampaign.id
    is Campaign.Banner.PromptBanner -> id
    is Campaign.Modal.PromptModal -> id
    is Campaign.UpgradeScreen.ComponentBoxUpgradeScreen -> promptCampaign.id
    is Campaign.UpgradeScreen.PromptUpgradeScreen -> id
    is Campaign.Banner.ComponentBoxBigBanner -> promptCampaign.id
    is Campaign.Banner.PromptBigBanner -> id
    is Campaign.Modal.ComponentBoxModal -> promptCampaign.id
    null -> null
}

fun Campaign?.componentBoxId() = when (this) {
    is Campaign.Banner.ComponentBoxBanner -> componentBoxId
    is Campaign.Modal.ComponentBoxModal -> componentBoxId
    is Campaign.UpgradeScreen.ComponentBoxUpgradeScreen -> componentBoxId
    else -> null
}