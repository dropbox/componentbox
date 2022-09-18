package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.impl.ComponentBoxIcon

interface Icon<Id : Any> : Asset {
    var id: Id
    var color: Color?

    companion object {
        fun <Id : Any> of(
            id: Id,
            modifier: Modifier? = null,
            actions: Actions? = null,
            color: Color? = null
        ): Icon<Id> = ComponentBoxIcon(id, modifier, actions, color)
    }
}