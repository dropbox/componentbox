@file:OptIn(ExperimentalFoundationApi::class)

package com.dropbox.componentbox.ui.surfaces.inspector.panels.main.modifier

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
import androidx.compose.foundation.layout.width
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
import com.dropbox.componentbox.Themer
import com.dropbox.componentbox.models.Color
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.store
import com.dropbox.componentbox.store.subscriptions.syncActiveNode
import com.dropbox.componentbox.ui.theme.buttonBackground
import com.dropbox.componentbox.ui.theme.disabledBackground
import com.dropbox.componentbox.ui.theme.inverseStandardBackground

@Composable
fun background(themer: Themer) {
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
                ComponentAction.ModifierAction.SetBackground(
                    id = activeNode.value!!.id,
                    background = color.value.title
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
                text = "Background color:",
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
                    modifier = Modifier.background(color = themer.toMaterialTheme(color.value)).height(18.dp)
                        .width(18.dp)
                )

                Box(modifier = Modifier.fillMaxWidth()) {

                    Text(
                        text = color.value.title,
                        color = themer.toMaterialTheme(color.value),
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
                                    modifier = Modifier.background(color = themer.toMaterialTheme(color)).height(15.dp)
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