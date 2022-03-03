package com.dropbox.componentbox.ui.surfaces.inspector.panels.main

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.Themer
import com.dropbox.componentbox.data.entities.Context
import com.dropbox.componentbox.ui.surfaces.inspector.panels.main.children.children
import com.dropbox.componentbox.ui.surfaces.inspector.panels.main.content.content
import com.dropbox.componentbox.ui.surfaces.inspector.panels.main.layout.layout
import com.dropbox.componentbox.ui.surfaces.inspector.panels.main.modifier.background
import com.dropbox.componentbox.ui.surfaces.inspector.panels.main.modifier.margin
import com.dropbox.componentbox.ui.surfaces.inspector.panels.main.modifier.padding
import com.dropbox.componentbox.ui.surfaces.inspector.panels.main.modifier.size
import com.dropbox.componentbox.ui.surfaces.inspector.panels.main.style.color
import com.dropbox.componentbox.ui.surfaces.inspector.panels.main.style.textStyle
import com.dropbox.componentbox.ui.surfaces.inspector.panels.panel

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