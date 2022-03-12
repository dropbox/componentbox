package com.dropbox.componentbox.presentation

import com.dropbox.componentbox.foundation.ComponentBox
import kotlinx.serialization.Serializable

@Serializable
data class ComponentBoxViewModel<C : ComponentBox>(
    val root: C? = null
)




