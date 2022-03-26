package com.dropbox.desktop.componentbox.ui.surfaces.toolbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dropbox.desktop.componentbox.data.entities.Node
import com.dropbox.componentbox.foundation.ComponentType
import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.actions.ScreenAction
import com.dropbox.desktop.componentbox.store.store
import com.dropbox.desktop.componentbox.store.subscriptions.syncActiveNode
import com.dropbox.desktop.componentbox.ui.theme.ComponentBoxIcon
import com.dropbox.desktop.componentbox.ui.theme.resourcePath
import com.dropbox.desktop.componentbox.ui.theme.standardBackgroundElevated
import com.dropbox.desktop.componentbox.util.node

@Composable
fun Toolbar() {
    Row(
        modifier = Modifier.fillMaxWidth().background(color = MaterialTheme.colors.standardBackgroundElevated),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ToolbarButtons()
        UserAvatarButton()
    }
}

@Composable
private fun ToolbarButtons() {
    val activeNode = remember { mutableStateOf<Node?>(null) }
    fun subscribe() {
        syncActiveNode(activeNode, store.state)
    }
    store.subscribe { subscribe() }

    Row {
        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.ListView.Line.resourcePath())

        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.Home.Line.resourcePath())

        AddContainerDropdownMenuButton()

        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.TextBox.Line.resourcePath()) {
            store.dispatch(ComponentAction.AddNode(ComponentType.Text.node(), activeNode.value?.id))
        }

        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.Image.Line.resourcePath()) {
            store.dispatch(ComponentAction.AddNode(ComponentType.Drawable.node(), activeNode.value?.id))
        }

        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.EarlyBird.Line.resourcePath()) {
            store.dispatch(ComponentAction.AddNode(ComponentType.Vector.node(), activeNode.value?.id))
        }

        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.Activity.Line.resourcePath()) {
            store.dispatch(ComponentAction.AddNode(ComponentType.Button.node(), activeNode.value?.id))
        }

        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.Table.Line.resourcePath()) {
            store.dispatch(ComponentAction.AddNode(ComponentType.Table.node(), activeNode.value?.id))
        }

        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.Theme.Line.resourcePath()) {
            store.dispatch(ScreenAction.ToggleNightMode)
        }

        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.Switcher.Line.resourcePath()) {
            store.dispatch(ScreenAction.ToggleBottomTabs)
        }

        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.Settings.Line.resourcePath())
        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.Help.Line.resourcePath())
        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.AddComment.Line.resourcePath())
        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.Share.Line.resourcePath())
        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.Heart.Line.resourcePath())

        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.Delete.Line.resourcePath(), tint = MaterialTheme.colors.error) {
            store.dispatch(ComponentAction.Clear)
        }

        BasicToolbarButton(iconResourcePath = ComponentBoxIcon.Twinkle1.Line.resourcePath(), tint = MaterialTheme.colors.primary) {
            store.dispatch(ComponentAction.ClearActiveNode)
        }
    }
}

@Composable
private fun UserAvatarButton() {
    Image(
        painter = painterResource("tag.jpeg"),
        contentDescription = null,
        modifier = Modifier.size(40.dp).clip(CircleShape)
    )
}