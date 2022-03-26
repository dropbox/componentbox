package com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.content

import androidx.compose.runtime.Composable
import com.dropbox.desktop.componentbox.data.entities.Context
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.selectInput

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