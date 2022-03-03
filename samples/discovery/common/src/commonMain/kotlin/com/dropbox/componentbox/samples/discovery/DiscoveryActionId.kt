package com.dropbox.componentbox.samples.discovery

enum class DiscoveryActionId {
    DismissPurchaseFlowUpsell,
    InitPurchaseFlow,
    NavigateFeatureDiscovery,
    Nothing
}

fun String?.action(): DiscoveryActionId {
    return when (this) {
        DiscoveryActionId.DismissPurchaseFlowUpsell.name -> DiscoveryActionId.DismissPurchaseFlowUpsell
        DiscoveryActionId.InitPurchaseFlow.name -> DiscoveryActionId.InitPurchaseFlow
        DiscoveryActionId.NavigateFeatureDiscovery.name -> DiscoveryActionId.NavigateFeatureDiscovery
        DiscoveryActionId.Nothing.name -> DiscoveryActionId.Nothing
        else -> DiscoveryActionId.Nothing
    }
}