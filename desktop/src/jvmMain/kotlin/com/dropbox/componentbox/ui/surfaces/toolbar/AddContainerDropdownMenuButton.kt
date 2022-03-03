package com.dropbox.componentbox.ui.surfaces.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.data.entities.Node
import com.dropbox.componentbox.models.ComponentType
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.store
import com.dropbox.componentbox.store.subscriptions.syncActiveNode
import com.dropbox.componentbox.ui.theme.ComponentBoxIcon
import com.dropbox.componentbox.ui.theme.buttonBackground
import com.dropbox.componentbox.ui.theme.inverseStandardBackground
import com.dropbox.componentbox.ui.theme.resourcePath
import com.dropbox.componentbox.util.node

@Composable
fun AddContainerDropdownMenuButton() {
    val isExpanded = remember { mutableStateOf(false) }
    val selectedContainerType = remember { mutableStateOf(ComponentType.Column) }

    val activeNode = remember { mutableStateOf<Node?>(null) }
    fun subscribe() {
        syncActiveNode(activeNode, store.state)
    }
    store.subscribe { subscribe() }

    Box {
        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.Square.Line.resourcePath()) {
            isExpanded.value = !isExpanded.value
        }

        DropdownMenu(
            modifier = Modifier.background(color = MaterialTheme.colors.buttonBackground),
            expanded = isExpanded.value,
            onDismissRequest = { isExpanded.value = false }) {
            containerTypes.forEach { containerType ->
                DropdownMenuItem(
                    onClick = {
                        selectedContainerType.value = containerType
                        isExpanded.value = false

                        store.dispatch(
                            ComponentAction.AddNode(
                                node = containerType.node(),
                                parentId = activeNode.value?.id
                            )
                        )
                    },
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.background)
                        .padding(0.dp)
                        .fillMaxWidth(),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(text = containerType.name, color = MaterialTheme.colors.inverseStandardBackground)
                }
            }
        }
    }
}

val containerTypes = listOf(
    ComponentType.Box,
    ComponentType.Row,
    ComponentType.LazyRow,
    ComponentType.Column,
    ComponentType.LazyColumn
)