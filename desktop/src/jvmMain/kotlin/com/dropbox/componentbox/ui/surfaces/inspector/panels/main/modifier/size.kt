@file:OptIn(ExperimentalFoundationApi::class)

package com.dropbox.componentbox.ui.surfaces.inspector.panels.main.modifier

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.store.actions.ComponentAction
import com.dropbox.componentbox.store.store
import com.dropbox.componentbox.store.subscriptions.syncActiveNode
import com.dropbox.componentbox.ui.theme.buttonBackground
import com.dropbox.componentbox.ui.theme.disabledBackground
import com.dropbox.componentbox.ui.theme.inverseStandardBackground

@Composable
fun size() {
    val activeNode = remember { mutableStateOf(store.state.componentState.activeNode) }

    val isFullSize = remember { mutableStateOf(false) }
    val isFullHeight = remember { mutableStateOf(false) }
    val isFullWidth = remember { mutableStateOf(false) }

    val size = remember { mutableStateOf<Int?>(null) }
    val height = remember { mutableStateOf<Int?>(null) }
    val width = remember { mutableStateOf<Int?>(null) }

    fun subscribe() {
        syncActiveNode(activeNode, store.state)
    }

    store.subscribe { subscribe() }

    fun setIsFullWidth(value: Boolean) {
        isFullWidth.value = value
        if (activeNode.value != null) {
            store.dispatch(ComponentAction.ModifierAction.SetFillMaxWidth(activeNode.value!!.id, value))
        }
    }

    fun setHeight(value: Int?) {
        height.value = value

        if (activeNode.value != null) {
            store.dispatch(ComponentAction.ModifierAction.SetHeight(activeNode.value!!.id, value ?: 0))
        }
    }

    fun setWidth(value: Int?) {
        width.value = value

        if (activeNode.value != null) {
            store.dispatch(ComponentAction.ModifierAction.SetWidth(activeNode.value!!.id, value ?: 0))
        }
    }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = "Size",
                color = MaterialTheme.colors.inverseStandardBackground
            )
        }

        LazyVerticalGrid(cells = GridCells.Adaptive(85.dp), verticalArrangement = Arrangement.Center) {

            item {
                Text(
                    text = "Size:",
                    color = MaterialTheme.colors.disabledBackground
                )
            }

            item {
                Checkbox(checked = isFullSize.value, onCheckedChange = { value -> setIsFullWidth(value) })
            }

            item {
                BasicTextField(
                    value = if (size.value != null) size.value.toString() else "",
                    onValueChange = { value -> size.value = value.toInt() },
                    modifier = Modifier.fillMaxWidth().background(color = MaterialTheme.colors.buttonBackground)
                        .padding(4.dp),
                    textStyle = TextStyle(color = MaterialTheme.colors.primary)
                )
            }
        }

        LazyVerticalGrid(cells = GridCells.Adaptive(85.dp), verticalArrangement = Arrangement.Center) {

            item {
                Text(
                    text = "Height:",
                    color = MaterialTheme.colors.disabledBackground
                )
            }

            item {
                Checkbox(checked = isFullHeight.value, onCheckedChange = { value -> setIsFullWidth(value) })
            }

            item {
                BasicTextField(
                    value = if (height.value != null) height.value.toString() else "",
                    onValueChange = { value -> setHeight(value.toInt()) },
                    modifier = Modifier.fillMaxWidth().background(color = MaterialTheme.colors.buttonBackground)
                        .padding(4.dp),
                    textStyle = TextStyle(color = MaterialTheme.colors.primary)
                )
            }
        }

        LazyVerticalGrid(cells = GridCells.Adaptive(85.dp), verticalArrangement = Arrangement.Center) {

            item {
                Text(
                    text = "Width:",
                    color = MaterialTheme.colors.disabledBackground
                )
            }

            item {
                Checkbox(checked = isFullWidth.value, onCheckedChange = { value -> setIsFullWidth(value) })
            }

            item {
                BasicTextField(
                    value = if (width.value != null) width.value.toString() else "",
                    onValueChange = { value -> setWidth(value.toInt()) },
                    modifier = Modifier.fillMaxWidth().background(color = MaterialTheme.colors.buttonBackground)
                        .padding(4.dp),
                    textStyle = TextStyle(color = MaterialTheme.colors.primary)
                )
            }
        }

        Divider(modifier = Modifier.fillMaxWidth().height(2.dp))
    }
}