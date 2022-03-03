package com.dropbox.componentbox.ui.surfaces.inspector.panels.root

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.ui.surfaces.inspector.panels.panel

@Composable
fun rootPanel() {
    panel("Root") {

        title()
        verticalArrangement()
        horizontalAlignment()
    }
}