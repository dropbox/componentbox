@file:OptIn(ExperimentalFoundationApi::class)

package com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.style

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.foundation.Color
import com.dropbox.componentbox.foundation.Themer
import com.dropbox.componentbox.util.compose
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.store
import com.dropbox.desktop.componentbox.store.subscriptions.syncActiveNode
import com.dropbox.desktop.componentbox.ui.theme.buttonBackground
import com.dropbox.desktop.componentbox.ui.theme.disabledBackground
import com.dropbox.desktop.componentbox.ui.theme.inverseStandardBackground

@Composable
fun color(themer: Themer) {
    val activeNode = remember { mutableStateOf(store.state.componentState.activeNode) }
    val color = remember { mutableStateOf(store.state.themeState.colors[0]) }
    val isExpanded = remember { mutableStateOf(false) }

    fun subscribe() {
        syncActiveNode(activeNode, store.state)
    }

    store.subscribe { subscribe() }

    fun setColor(value: Color) {
        color.value = value
        if (activeNode.value != null) {
            store.dispatch(
                ComponentAction.SetColor(
                    id = activeNode.value!!.id,
                    color = color.value
                )
            )
        }
    }

    LazyVerticalGrid(
        cells = GridCells.Adaptive(120.dp),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Start
    ) {

        item {
            Text(
                text = "Color:",
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
                Box(
                    modifier = Modifier.background(color = color.value.compose()).height(18.dp)
                        .width(18.dp)
                )

                Box(modifier = Modifier.fillMaxWidth()) {

                    Text(
                        text = color.value.title,
                        color = color.value.compose(),
                        modifier = Modifier.clickable { isExpanded.value = true }
                            .background(color = MaterialTheme.colors.buttonBackground).fillMaxWidth()
                    )

                    DropdownMenu(
                        modifier = Modifier.background(color = MaterialTheme.colors.buttonBackground).height(300.dp),
                        expanded = isExpanded.value,
                        onDismissRequest = { isExpanded.value = false }) {
                        store.state.themeState.colors.forEach { color ->
                            DropdownMenuItem(
                                onClick = {
                                    setColor(color)
                                    isExpanded.value = false
                                },
                                modifier = Modifier.background(color = MaterialTheme.colors.background).padding(0.dp)
                                    .fillMaxWidth(),
                                contentPadding = PaddingValues(0.dp)
                            ) {
                                Box(
                                    modifier = Modifier.background(color = color.compose()).height(15.dp)
                                        .width(15.dp)
                                )
                                Text(text = color.title, color = MaterialTheme.colors.inverseStandardBackground)
                            }
                        }
                    }
                }
            }
        }
    }
}