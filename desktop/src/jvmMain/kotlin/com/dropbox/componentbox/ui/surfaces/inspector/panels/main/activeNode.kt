package com.dropbox.componentbox.ui.surfaces.inspector.panels.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.data.entities.Node
import com.dropbox.componentbox.store.store
import com.dropbox.componentbox.store.subscriptions.syncActiveNode
import com.dropbox.componentbox.ui.theme.disabledBackground

@Composable
fun activeNode() {
    val activeNode = remember { mutableStateOf<Node?>(null) }

    fun subscribe() {
        syncActiveNode(activeNode, store.state)
    }

    store.subscribe { subscribe() }

    if (activeNode.value != null) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = activeNode.value!!.type.name,
                color = MaterialTheme.colors.disabledBackground
            )

            Text(
                text = activeNode.value!!.id,
                color = MaterialTheme.colors.disabledBackground
            )

            Icon(
                painter = painterResource("drawable/ic_dig_compass_line.xml"),
                contentDescription = null,
                tint = MaterialTheme.colors.disabledBackground
            )
        }

        Divider(modifier = Modifier.fillMaxWidth().height(2.dp))
    }
}