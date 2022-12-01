package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.impl.ComponentBoxSwitch

interface Switch : Component {
    var checked: Boolean?

    companion object {
        fun of(
            modifier: Modifier? = null,
            actions: Actions? = null,
            checked: Boolean? = null,
        ): Switch = ComponentBoxSwitch(
            modifier = modifier,
            actions = actions,
            checked = checked,
        )
    }
}