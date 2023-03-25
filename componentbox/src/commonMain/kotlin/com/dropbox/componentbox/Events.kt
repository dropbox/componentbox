package com.dropbox.componentbox

import kotlinx.serialization.Serializable

/**
 * Represents user-triggered events.
 */
@Serializable
data class Events(
    val onClick: (() -> Unit)? = null,
    val onLongClick: (() -> Unit)? = null
)