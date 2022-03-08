package com.dropbox.componentbox.discovery.discovery.campaigns.data


import kotlinx.serialization.Serializable


sealed class Campaign {
    data class Banner(
        val id: String,
        val text: String,
        val subtext: String,
        val style: BannerStyle,
        val action: CampaignAction,
        val iconStart: String,
        val iconEnd: String,
        val componentBoxId: String?
    ) : Campaign()

    data class Modal(
        val id: String,
        val title: String,
        val componentBoxId: String?
    ) : Campaign()

    data class Screen(
        val id: String,
        val title: String,
        val text: String,
        val subtext: String,
        val componentBoxId: String?
    ) : Campaign()
}


@Serializable
enum class BannerStyle {
    Info,
    Notification,
    Warning,
    Promotion
}

enum class CampaignAction {
    OpenUpsellScreen,
    OpenFeatureDiscoveryScreen
}

fun Campaign?.id() = when (this) {
    is Campaign.Banner -> this.id
    is Campaign.Modal -> this.id
    is Campaign.Screen -> this.id
    else -> ""
}

fun Campaign?.componentBoxId() = when (this) {
    is Campaign.Banner -> this.componentBoxId
    is Campaign.Modal -> this.componentBoxId
    is Campaign.Screen -> this.componentBoxId
    else -> null
}