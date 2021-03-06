package com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.content

import androidx.compose.runtime.Composable
import com.dropbox.desktop.componentbox.data.entities.Context
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.selectInput

@Composable
fun image(context: Context) {
    val images = context.resourceProvider.images().list()
    selectInput(LABEL, images) { id, selection ->
        ComponentAction.SetDrawableName(
            id = id,
            name = selection.name
        )
    }
}

private const val LABEL = "Image name:"