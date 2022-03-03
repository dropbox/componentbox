package com.dropbox.componentbox.samples.discovery

import com.dropbox.componentbox.models.ComponentBox
import kotlinx.serialization.Serializable

@Serializable
data class DiscoveryScreenViewModel(
    val screen: ComponentBox.Screen
)