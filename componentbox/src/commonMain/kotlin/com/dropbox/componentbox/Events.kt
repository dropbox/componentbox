package com.dropbox.componentbox

/**
 * Represents user-triggered events.
 */
data class Events(
    val onClick: (() -> Unit)? = null,
    val onLongClick: (() -> Unit)? = null
)