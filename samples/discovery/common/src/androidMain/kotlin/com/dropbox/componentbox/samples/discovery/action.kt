package com.dropbox.componentbox.samples.discovery

actual fun DiscoveryAction.action(): () -> Unit {
   return when (this) {
        is DiscoveryAction.Dismiss.DismissPurchaseFlowUpsell -> {{}}
        is DiscoveryAction.Navigate.FeatureDiscovery -> {{}}
        is DiscoveryAction.Nothing.Void -> {{}}
        is DiscoveryAction.Purchase.InitPurchaseFlow -> {{}}
    }
}