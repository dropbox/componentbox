package com.dropbox.componentbox.ui.surfaces.inspector.panels.main.children

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.dropbox.componentbox.data.entities.Node
import com.dropbox.componentbox.store.store
import com.dropbox.componentbox.store.subscriptions.syncActiveNode
import com.dropbox.componentbox.store.subscriptions.syncChildrenNodes
import com.dropbox.componentbox.ui.surfaces.inspector.panels.section
import com.dropbox.componentbox.ui.theme.successFill
import com.dropbox.componentbox.utils.iconResourcePath

@Composable
fun children() {
    val activeNode = remember { mutableStateOf<Node?>(null) }
    val childrenNodes = remember { mutableStateListOf<Node>() }

    fun subscribe() {
        syncActiveNode(activeNode, store.state)
        syncChildrenNodes(childrenNodes, store.state)
    }

    store.subscribe { subscribe() }

    section("Children") {
        LazyColumn {
            items(childrenNodes) { node ->
                Row(modifier = Modifier.clickable { }) {
                    Icon(
                        painter = painterResource(node.type.iconResourcePath()),
                        contentDescription = null,
                        tint = MaterialTheme.colors.successFill
                    )
                }
            }
        }

        addChild()
    }
}