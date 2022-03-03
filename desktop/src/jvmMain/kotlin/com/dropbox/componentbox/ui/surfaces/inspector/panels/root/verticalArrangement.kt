package com.dropbox.componentbox.ui.surfaces.inspector.panels.root

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.models.Arrangement
import com.dropbox.componentbox.store.actions.ScreenAction
import com.dropbox.componentbox.ui.surfaces.inspector.panels.selectInput

@Composable
fun verticalArrangement() {
    selectInput(LABEL, Arrangement.values().toList()) { _, selection ->
        ScreenAction.SetVerticalArrangement(arrangement = selection)
    }
}

private const val LABEL = "Vertical arrangement:"