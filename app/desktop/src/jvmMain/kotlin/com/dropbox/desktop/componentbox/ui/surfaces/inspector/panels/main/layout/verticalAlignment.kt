package com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.layout

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.selectInput

@Composable
fun verticalAlignment() {
    selectInput(LABEL, Alignment.values().toList()) { id, selection ->
        ComponentAction.LayoutAction.SetVerticalAlignment(
            id = id,
            verticalAlignment = selection
        )
    }
}

private const val LABEL = "Vertical alignment:"