package com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.content

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.dropbox.desktop.componentbox.data.entities.Context
import com.dropbox.desktop.componentbox.data.entities.Node
import com.dropbox.desktop.componentbox.store.store
import com.dropbox.desktop.componentbox.store.subscriptions.syncActiveNode
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.section

@Composable
fun content(context: Context) {
    val activeNode = remember { mutableStateOf<Node?>(null) }

    fun subscribe() {
        syncActiveNode(activeNode, store.state)
    }

    store.subscribe { subscribe() }

    section(title = "Content") {
        text()
        image(context)
        icon(context)
        drawable()
    }
}