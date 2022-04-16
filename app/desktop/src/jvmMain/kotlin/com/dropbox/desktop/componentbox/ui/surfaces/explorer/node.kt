package com.dropbox.desktop.componentbox.ui.surfaces.explorer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dropbox.desktop.componentbox.data.entities.Node
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.store
import com.dropbox.desktop.componentbox.store.subscriptions.syncActiveNode
import com.dropbox.desktop.componentbox.ui.theme.disabledBackground
import com.dropbox.desktop.componentbox.ui.theme.standardBackgroundElevated

@Composable
fun node(node: Node, isRoot: Boolean, offsetX: Int = 0) {
    val activeNode = remember { mutableStateOf(store.state.componentState.activeNode) }

    fun subscribe() {
        syncActiveNode(activeNode, store.state)
    }

    store.subscribe { subscribe() }

    Column {
        Row(
            modifier = Modifier.fillMaxWidth().padding(8.dp)
                .background(color = if (isRoot) MaterialTheme.colors.standardBackgroundElevated else Color.Transparent)
                .clickable {
                    store.dispatch(ComponentAction.SetActiveNode(node))
                }
        ) {

            if (isRoot && node.children.isNotEmpty()) {
                Icon(
                    painter = painterResource(CHEVRON_UP_LINE_RESOURCE_PATH),
                    contentDescription = null,
                    tint = MaterialTheme.colors.disabledBackground
                )
            }

            Text(
                text = node.type.name,
                color = if (node.id == activeNode.value?.id) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp, start = offsetX.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )

            Text(
                text = node.id,
                color = if (node.id == activeNode.value?.id) MaterialTheme.colors.primary else MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                fontWeight = FontWeight.Light,
                fontSize = 12.sp
            )
        }
    }

    node.children.forEach { child ->
        node(child, false, offsetX + 20)
    }
}

const val CHEVRON_UP_LINE_RESOURCE_PATH = "drawable/ic_dig_chevron_up_line.xml"