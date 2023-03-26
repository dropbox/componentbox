package com.dropbox.componentbox

import kotlinx.serialization.Serializable

/**
 * Represents a response to a user-triggered event.
 */
sealed class Action {
    /**
     * Models events with semantic identifiers.
     * @param Event Used on deserialization to map the event to a lambda function.
     */
    @Serializable
    data class Semantic<out Event : Any>(
        val event: Event
    ) : Action()

    /**
     * Models events with lambda functions.
     */
    data class Lambda(
        val run: () -> Unit
    ) : Action()
}

fun lambda(run: () -> Unit) = Action.Lambda(run)
fun <Event : Any> semantic(run: () -> Event) = Action.Semantic(run())