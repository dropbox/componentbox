package com.dropbox.componentbox.samples.discovery

import com.dropbox.componentbox.foundation.Destination

sealed class DiscoveryDestination : Destination() {
    object Home : DiscoveryDestination()
    object Photos : DiscoveryDestination()
    object Plans : DiscoveryDestination()
    object Account : DiscoveryDestination()
}