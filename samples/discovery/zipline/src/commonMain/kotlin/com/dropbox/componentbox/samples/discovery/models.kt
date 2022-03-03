package com.dropbox.componentbox.samples.discovery

import kotlinx.serialization.Serializable

@Serializable
sealed class DiscoveryEvent {
    @Serializable
    data class Tap(
        val componentId: String
    ): DiscoveryEvent()
}