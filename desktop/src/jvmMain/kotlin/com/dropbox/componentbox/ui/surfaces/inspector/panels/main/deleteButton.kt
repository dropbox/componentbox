package com.dropbox.componentbox.ui.surfaces.inspector.panels.main

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.dropbox.componentbox.data.entities.Node
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.store
import com.dropbox.componentbox.store.subscriptions.syncActiveNode
import com.dropbox.componentbox.ui.theme.inverseStandardBackground

@Composable
fun deleteButton() {
    val activeNode = remember { mutableStateOf<Node?>(null) }

    fun subscribe() {
        syncActiveNode(activeNode, store.state)
    }

    store.subscribe { subscribe() }

    if (activeNode.value != null) {
        Button(
            onClick = { store.dispatch(ComponentAction.RemoveNode(activeNode.value!!.id)) },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.error)
        ) {
            Text(text = "Delete", color = MaterialTheme.colors.inverseStandardBackground)
        }
    }
}
