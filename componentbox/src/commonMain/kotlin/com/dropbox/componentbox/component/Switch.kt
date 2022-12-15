package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Events
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.impl.ComponentBoxSwitch

interface Switch : Component {
    var checked: Boolean?

    companion object {
        fun of(
            modifier: Modifier? = null,
            events: Events? = null,
            checked: Boolean? = null,
        ): Switch = ComponentBoxSwitch(
            modifier = modifier,
            events = events,
            checked = checked,
        )
    }
}