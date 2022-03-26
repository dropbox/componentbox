package com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.root

import androidx.compose.runtime.Composable
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.panel

@Composable
fun rootPanel() {
    panel("Root") {

        title()
        verticalArrangement()
        horizontalAlignment()
    }
}