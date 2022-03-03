package com.dropbox.componentbox.ui.surfaces.inspector.panels.main.style

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.data.entities.Context
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.ui.surfaces.inspector.panels.selectInput

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