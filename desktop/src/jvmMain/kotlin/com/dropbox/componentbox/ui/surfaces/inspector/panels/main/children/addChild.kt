@file:OptIn(ExperimentalFoundationApi::class)

package com.dropbox.componentbox.ui.surfaces.inspector.panels.main.children

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.data.entities.Node
import com.dropbox.componentbox.foundation.ComponentType
import com.dropbox.componentbox.store.store
import com.dropbox.componentbox.store.subscriptions.syncActiveNode
import com.dropbox.componentbox.ui.theme.buttonBackground
import com.dropbox.componentbox.ui.theme.disabledBackground
import com.dropbox.componentbox.ui.theme.inverseStandardBackground
import com.dropbox.componentbox.ui.theme.successFill

@Composable
fun addChild() {
    val activeNode = remember { mutableStateOf<Node?>(null) }
    val componentType = remember { mutableStateOf(ComponentType.Column) }
    val isExpanded = remember { mutableStateOf(false) }

    fun setComponentType(value: ComponentType) {
        componentType.value = value
    }

    fun subscribe() {
        syncActiveNode(activeNode, store.state)
    }

    store.subscribe { subscribe() }

    LazyVerticalGrid(
        cells = GridCells.Adaptive(120.dp),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Start
    ) {

        item {
            Text(
                text = "Add child:",
                color = MaterialTheme.colors.disabledBackground,
                modifier = Modifier.padding(0.dp)
            )
        }

        item {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Box(modifier = Modifier.fillMaxWidth()) {

                    Text(
                        text = componentType.value.name,
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.clickable { isExpanded.value = true }
                            .background(color = MaterialTheme.colors.buttonBackground).fillMaxWidth()
                    )

                    DropdownMenu(
                        modifier = Modifier.background(color = MaterialTheme.colors.buttonBackground).height(300.dp),
                        expanded = isExpanded.value,
                        onDismissRequest = { isExpanded.value = false }) {
                        ComponentType.values().forEach { type ->
                            DropdownMenuItem(
                                onClick = {
                                    setComponentType(type)
                                    isExpanded.value = false
                                },
                                modifier = Modifier.background(color = MaterialTheme.colors.background).padding(0.dp)
                                    .fillMaxWidth(),
                                contentPadding = PaddingValues(0.dp)
                            ) {
                                Text(text = type.name, color = MaterialTheme.colors.inverseStandardBackground)
                            }
                        }
                    }
                }
            }
        }

        item {
            Box(modifier = Modifier.height(22.dp)) {
                IconButton(onClick = {}) {
                    Icon(
                        painter = painterResource("drawable/ic_dig_add_circle_fill.xml"),
                        contentDescription = null,
                        tint = MaterialTheme.colors.successFill
                    )
                }
            }
        }
    }
}