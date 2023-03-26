package com.dropbox.componentbox

import kotlinx.serialization.Serializable

/**
 * Represents a user-triggered event.
 */
sealed class Event {
    /**
     * Models events with semantic identifiers.
     * @param Id Used on deserialization to map the event to a lambda function.
     */
    @Serializable
    data class Semantic<Id : Any>(
        val id: Id
    ) : Event()

    /**
     * Models events with lambda functions.
     */
    data class Lambda(
        val run: () -> Unit
    ) : Event()
}