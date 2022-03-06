package com.dropbox.componentbox.samples.discovery

import kotlinx.serialization.Serializable

@Serializable
sealed class ComponentBoxEvent {
    @Serializable
    data class Tap(
        val componentId: String
    ): ComponentBoxEvent()
}