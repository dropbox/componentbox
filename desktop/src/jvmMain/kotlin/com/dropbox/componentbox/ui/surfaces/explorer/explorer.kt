package com.dropbox.componentbox.ui.surfaces.explorer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.data.entities.Node
import com.dropbox.componentbox.store.store
import com.dropbox.componentbox.store.subscriptions.syncActiveNode
import com.dropbox.componentbox.store.subscriptions.syncNodes
import com.dropbox.componentbox.ui.components.searchIcon
import com.dropbox.componentbox.ui.theme.buttonBackground
import com.dropbox.componentbox.ui.theme.paperBackground

@Composable
fun explorer() {
    val nodes = remember { mutableStateListOf<Node>() }
    val activeNode = remember { mutableStateOf<Node?>(null) }

    fun subscribe() {
        syncNodes(nodes, store.state)
        syncActiveNode(activeNode, store.state)
    }

    store.subscribe { subscribe() }

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .width(400.dp)
            .background(color = MaterialTheme.colors.paperBackground)
            .padding(8.dp)
    ) {

        item {
            TextField(
                leadingIcon = { searchIcon() },
                value = SEARCH_LABEL,
                onValueChange = {},
                colors = TextFieldDefaults.textFieldColors(
                    textColor = MaterialTheme.colors.onBackground,
                    leadingIconColor = MaterialTheme.colors.onBackground
                ),
                modifier = Modifier.clip(
                    RoundedCornerShape(10.dp)
                ).background(color = MaterialTheme.colors.buttonBackground)
            )
        }

        items(nodes) { node ->
            node(node, true)
        }
    }
}

const val SEARCH_LABEL = "Search..."