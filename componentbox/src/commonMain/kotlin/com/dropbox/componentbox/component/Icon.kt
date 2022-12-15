package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Events
import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.impl.ComponentBoxIcon

interface Icon<Id : Any> : Asset {
    var id: Id
    var color: Color?
    val contentDescription: String?

    companion object {
        fun <Id : Any> of(
            id: Id,
            modifier: Modifier? = null,
            events: Events? = null,
            color: Color? = null,
            contentDescription: String? = null
        ): Icon<Id> = ComponentBoxIcon(id, modifier, events, color, contentDescription)
    }
}