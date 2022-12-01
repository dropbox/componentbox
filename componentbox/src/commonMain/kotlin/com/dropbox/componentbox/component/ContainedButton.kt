package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.impl.ComponentBoxContainedButton

interface ContainedButton : Button {
    companion object {
        fun of(
            components: MutableList<Component>? = null,
            disabled: Boolean? = false,
            modifier: Modifier? = null,
            actions: Actions? = null
        ): ContainedButton = ComponentBoxContainedButton(
            components = components,
            disabled = disabled,
            modifier = modifier,
            actions = actions
        )
    }
}