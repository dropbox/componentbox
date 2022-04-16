package com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.root

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.desktop.componentbox.store.actions.ScreenAction
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.selectInput

@Composable
fun horizontalAlignment() {
    selectInput(LABEL, Alignment.values().toList()) { _, selection ->
        ScreenAction.SetHorizontalAlignment(alignment = selection)
    }
}

private const val LABEL = "Horizontal alignment:"