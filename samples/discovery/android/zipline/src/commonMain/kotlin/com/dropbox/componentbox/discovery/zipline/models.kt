package com.dropbox.componentbox.discovery.zipline

import kotlinx.serialization.Serializable

@Serializable
sealed class ComponentBoxEvent {
    @Serializable
    data class Tap(
        val componentId: String
    ): ComponentBoxEvent()
}