package com.dropbox.componentbox

import kotlinx.serialization.Serializable


sealed class Events {
    @Serializable
    data class Semantic<Id : Any>(
        val onClick: Action.Semantic<Id>,
        val onLongClick: Action.Semantic<Id>
    ) : Events()

    data class Lambda(
        val onClick: Action.Lambda,
        val onLongClick: Action.Lambda
    ) : Events()
}