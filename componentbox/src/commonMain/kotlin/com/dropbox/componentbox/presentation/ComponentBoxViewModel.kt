package com.dropbox.componentbox.presentation

import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.foundation.Passable
import com.dropbox.componentbox.foundation.IsPassable
import kotlinx.serialization.Serializable

@IsPassable
@Serializable
data class ComponentBoxViewModel<C : ComponentBox>(
    val root: C? = null
) : Passable




