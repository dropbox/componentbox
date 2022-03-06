package com.dropbox.componentbox.samples.discovery

import com.dropbox.componentbox.models.ComponentBox
import kotlinx.serialization.Serializable

@Serializable
data class ComponentBoxViewModel<C : ComponentBox>(
    val root: C? = null
)