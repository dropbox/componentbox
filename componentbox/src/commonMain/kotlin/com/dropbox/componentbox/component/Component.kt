package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Events
import com.dropbox.componentbox.foundation.Modifier

sealed interface Component {
    var modifier: Modifier?
    var events: Events?

    sealed interface Box : Component {
        val components: MutableList<Component>?
    }
}