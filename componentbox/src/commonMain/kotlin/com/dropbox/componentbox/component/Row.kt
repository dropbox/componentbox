package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.impl.ComponentBoxRow

interface Row : Component.Box {
    var horizontalArrangement: Arrangement.Horizontal?
    var verticalAlignment: Alignment.Vertical?

    companion object {
        fun of(
            modifier: Modifier? = null,
            actions: Actions? = null,
            components: MutableList<Component>? = null,
            horizontalArrangement: Arrangement.Horizontal? = null,
            verticalAlignment: Alignment.Vertical? = null
        ): Row = ComponentBoxRow(
            modifier = modifier,
            actions = actions,
            components = components,
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = verticalAlignment
        )
    }
}
