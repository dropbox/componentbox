package com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Themer
import com.dropbox.desktop.componentbox.data.entities.Context
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.children.children
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.content.content
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.layout.layout
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.modifier.background
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.modifier.margin
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.modifier.padding
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.modifier.size
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.style.color
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.style.textStyle
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.panel

@Composable
fun mainPanel(context: Context, themer: Themer) {
    panel("Component") {
        activeNode()

        content(context)
        textStyle(context)
        color(themer)
        margin()
        padding()
        size()
        background(themer)
        layout(context)
        children()

        deleteButton()
    }
}