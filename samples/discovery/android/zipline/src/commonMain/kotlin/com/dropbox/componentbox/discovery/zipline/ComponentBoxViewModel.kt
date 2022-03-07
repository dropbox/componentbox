package com.dropbox.componentbox.discovery.zipline

import com.dropbox.componentbox.models.ComponentBox
import kotlinx.serialization.Serializable

@Serializable
data class ComponentBoxScreenViewModel(
    val root: ComponentBox.Screen? = null
)

@Serializable
data class ComponentBoxModalViewModel(
    val root: ComponentBox.Modal? = null
)

@Serializable
data class ComponentBoxBannerViewModel(
    val root: ComponentBox.Banner? = null
)