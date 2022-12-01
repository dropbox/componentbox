package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.impl.ComponentBoxLazyRow

interface LazyRow : Row {
    companion object {
        fun of(
            modifier: Modifier? = null,
            actions: Actions? = null,
            components: MutableList<Component>? = null,
            horizontalArrangement: Arrangement.Horizontal? = null,
            verticalAlignment: Alignment.Vertical? = null
        ): LazyRow = ComponentBoxLazyRow(
            modifier = modifier,
            actions = actions,
            components = components,
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = verticalAlignment
        )
    }

}