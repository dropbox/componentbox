package com.dropbox.componentbox.ui.surfaces.inspector.panels.main.content

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.data.entities.Context
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.ui.surfaces.inspector.panels.selectInput

@Composable
fun icon(context: Context) {
    val icons = context.resourceProvider.icons().resPaths()
    selectInput(LABEL, icons) { id, selection ->
        ComponentAction.SetVectorName(
            id = id,
            name = selection.name
        )
    }
}

private const val LABEL = "Icon name:"