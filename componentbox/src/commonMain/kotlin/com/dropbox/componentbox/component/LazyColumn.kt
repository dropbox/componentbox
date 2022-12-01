package com.dropbox.componentbox.component

import com.dropbox.componentbox.foundation.Actions
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.impl.ComponentBoxLazyColumn

interface LazyColumn : Column {
    companion object {
        fun of(
            modifier: Modifier? = null,
            actions: Actions? = null,
            components: MutableList<Component>? = null,
            verticalArrangement: Arrangement.Vertical? = null,
            horizontalAlignment: Alignment.Horizontal? = null
        ): LazyColumn = ComponentBoxLazyColumn(
            modifier = modifier,
            actions = actions,
            components = components,
            verticalArrangement = verticalArrangement,
            horizontalAlignment = horizontalAlignment
        )
    }
}