package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Modifier

sealed interface Component {
    var modifier: Modifier?
    var actions: Actions?

    sealed interface Box : Component {
        val components: MutableList<Component>?
    }
}