package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Events
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.impl.ComponentBoxTextButton

interface TextButton : Button {
    companion object {
        fun of(
            components: MutableList<Component>? = null,
            disabled: Boolean? = false,
            modifier: Modifier? = null,
            events: Events? = null
        ): TextButton = ComponentBoxTextButton(
            components = components,
            disabled = disabled,
            modifier = modifier,
            events = events
        )
    }
}