package com.dropbox.componentbox

import kotlinx.serialization.Serializable


sealed class Events {
    @Serializable
    data class Semantic<Id : Any>(
        val onClick: Event.Semantic<Id>,
        val onLongClick: Event.Semantic<Id>
    ) : Events()

    data class Lambda(
        val onClick: Event.Lambda,
        val onLongClick: Event.Lambda
    ) : Events()
}