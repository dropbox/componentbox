package com.dropbox.componentbox.samples.discovery

import kotlinx.serialization.Serializable

@Serializable
sealed class DiscoveryAction {
    interface Required {
        val id: DiscoveryActionId
    }

    @Serializable
    sealed class Navigate : Required, DiscoveryAction() {
        @Serializable
        class FeatureDiscovery : Navigate() {
            override val id = DiscoveryActionId.NavigateFeatureDiscovery
        }
    }

    @Serializable
    sealed class Purchase : Required, DiscoveryAction() {
        @Serializable
        class InitPurchaseFlow : Purchase() {
            override val id = DiscoveryActionId.InitPurchaseFlow
        }
    }

    @Serializable
    sealed class Dismiss : Required, DiscoveryAction() {
        @Serializable
        class DismissPurchaseFlowUpsell : Dismiss() {
            override val id = DiscoveryActionId.DismissPurchaseFlowUpsell
        }
    }

    @Serializable
    sealed class Nothing : Required, DiscoveryAction() {
        @Serializable
        class Void : Nothing() {
            override val id = DiscoveryActionId.Nothing
        }
    }
}

fun DiscoveryActionId.action(): DiscoveryAction {
    return when (this) {
        DiscoveryActionId.DismissPurchaseFlowUpsell -> DiscoveryAction.Dismiss.DismissPurchaseFlowUpsell()
        DiscoveryActionId.InitPurchaseFlow -> DiscoveryAction.Purchase.InitPurchaseFlow()
        DiscoveryActionId.NavigateFeatureDiscovery -> DiscoveryAction.Navigate.FeatureDiscovery()
        DiscoveryActionId.Nothing -> DiscoveryAction.Nothing.Void()
    }
}

expect fun DiscoveryAction.action(): () -> Unit