package com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.style

import androidx.compose.runtime.Composable
import com.dropbox.desktop.componentbox.data.entities.Context
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.selectInput

@Composable
fun textStyle(context: Context) {
    val textStyles = context.resourceProvider.typography().list()
    selectInput(LABEL, textStyles) { id, selection ->
        ComponentAction.SetTextStyle(
            id = id,
            style = selection.name
        )
    }
}

private const val LABEL = "Text style:"