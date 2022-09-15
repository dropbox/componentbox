package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.impl.ComponentBoxTextButton

interface TextButton : Button {
    companion object {
        fun of(
            components: MutableList<Component>? = null,
            disabled: Boolean? = false,
            modifier: Modifier? = null,
            actions: Actions? = null
        ): TextButton = ComponentBoxTextButton(
            components = components,
            disabled = disabled,
            modifier = modifier,
            actions = actions
        )
    }
}