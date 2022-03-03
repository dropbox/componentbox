package com.dropbox.componentbox.ui.surfaces.inspector.panels.main.layout

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.models.Arrangement
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.ui.surfaces.inspector.panels.selectInput

@Composable
fun horizontalArrangement() {
    selectInput(LABEL, Arrangement.values().toList()) { id, selection ->
        ComponentAction.LayoutAction.SetHorizontalArrangement(
            id = id,
            horizontalArrangement = selection
        )
    }
}

private const val LABEL = "Horizontal arrangement:"