package com.dropbox.desktop.componentbox.store.state

import com.dropbox.desktop.componentbox.data.entities.Node
import com.dropbox.componentbox.foundation.Component

data class ComponentState(
    var nodes: MutableList<Node> = mutableListOf(),
    var idToComponent: MutableMap<String, Component> = mutableMapOf(),
    var activeNode: Node? = null,
    var rootComponents: MutableList<Component> = mutableListOf()
)