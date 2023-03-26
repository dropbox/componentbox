package com.dropbox.componentbox

import kotlinx.serialization.Serializable

/**
 * Represents user-triggered events.
 */
@Serializable
sealed class Events {
    /**
     * Models events with semantic identifiers.
     * @param Id Used on deserialization to map the event to a lambda function.
     */
    data class Semantic<Id : Any>(
        val onClick: Id,
        val onLongClick: Id,
    ) : Events()

    /**
     * Models events with lambda functions.
     */
    data class Lambda(
        val onClick: (() -> Unit)? = null,
        val onLongClick: (() -> Unit)? = null
    ) : Events()
}
