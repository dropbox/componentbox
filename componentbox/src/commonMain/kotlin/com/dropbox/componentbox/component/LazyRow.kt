package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Events
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.impl.ComponentBoxLazyRow

interface LazyRow : Row {
    companion object {
        fun of(
            modifier: Modifier? = null,
            events: Events? = null,
            components: MutableList<Component>? = null,
            horizontalArrangement: Arrangement.Horizontal? = null,
            verticalAlignment: Alignment.Vertical? = null
        ): LazyRow = ComponentBoxLazyRow(
            modifier = modifier,
            events = events,
            components = components,
            horizontalArrangement = horizontalArrangement,
            verticalAlignment = verticalAlignment
        )
    }

}