package com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.export

import androidx.compose.runtime.Composable
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.panel

@Composable
fun exportPanel() {
    panel("Export") {
        exportbutton()
    }
}