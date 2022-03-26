package com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.layout

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.selectInput

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