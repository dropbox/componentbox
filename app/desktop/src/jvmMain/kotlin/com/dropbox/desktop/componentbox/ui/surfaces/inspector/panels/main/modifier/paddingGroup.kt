@file:OptIn(ExperimentalFoundationApi::class)

package com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.main.modifier

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dropbox.desktop.componentbox.store.store
import com.dropbox.desktop.componentbox.store.subscriptions.syncActiveNode
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels.numberInput
import com.dropbox.desktop.componentbox.ui.theme.inverseStandardBackground

@Composable
internal fun paddingGroup(title: String, dispatch: (change: Change, nodeId: String) -> Unit) {
    val activeNode = remember { mutableStateOf(store.state.componentState.activeNode) }

    val start = remember { mutableStateOf(0) }
    val top = remember { mutableStateOf(0) }
    val end = remember { mutableStateOf(0) }
    val bottom = remember { mutableStateOf(0) }

    val inputs = listOf(
        Input(start, "Start:", Type.Start),
        Input(top, "Top:", Type.Top),
        Input(end, "End:", Type.End),
        Input(bottom, "Bottom:", Type.Bottom),
    )

    fun setLocalState(change: Change) {
        when (change.type) {
            Type.Start -> start.value = change.value
            Type.Top -> top.value = change.value
            Type.End -> end.value = change.value
            Type.Bottom -> bottom.value = change.value
        }
    }

    fun onChange(change: Change) {
        setLocalState(change)

        if (activeNode.value?.id != null) {
            dispatch(change, activeNode.value!!.id)
        }
    }

    fun subscribe() {
        syncActiveNode(activeNode, store.state)
    }

    store.subscribe { subscribe() }

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {

            Text(
                text = title,
                color = MaterialTheme.colors.inverseStandardBackground
            )
        }

        inputs.forEach { type ->
            numberInput(type.state, type.label) { input ->
                onChange(Change(type.type, input.trim().toInt()))
            }
        }

    }
}

internal data class Change(
    val type: Type,
    val value: Int
)

internal enum class Type {
    Start,
    Top,
    End,
    Bottom
}

private data class Input(
    val state: MutableState<Int>,
    val label: String,
    val type: Type
)