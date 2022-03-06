package com.dropbox.componentbox.discovery.zipline

import com.dropbox.componentbox.models.ComponentBox
import kotlinx.serialization.Serializable

@Serializable
data class ComponentBoxViewModel<C : ComponentBox>(
    val root: C? = null
)