package com.dropbox.componentbox.ui.surfaces.inspector.panels.main.layout

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.ui.surfaces.inspector.panels.selectInput

@Composable
fun verticalArrangement() {
    selectInput(LABEL, Arrangement.values().toList()) { id, selection ->
        ComponentAction.LayoutAction.SetVerticalArrangement(
            id = id,
            verticalArrangement = selection
        )
    }
}

private const val LABEL = "Vertical arrangement:"