package com.dropbox.componentbox.ui.surfaces.inspector.panels.main.layout

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.ui.surfaces.inspector.panels.selectInput

@Composable
fun horizontalAlignment() {
    selectInput(LABEL, Alignment.values().toList()) { id, selection ->
        ComponentAction.LayoutAction.SetHorizontalAlignment(
            id = id,
            horizontalAlignment = selection
        )
    }
}

private const val LABEL = "Horizontal alignment:"