package com.dropbox.componentbox

import kotlinx.serialization.Serializable

@Serializable
data class ComponentBoxConfig(
    val file: String,
    val tree: String
)
