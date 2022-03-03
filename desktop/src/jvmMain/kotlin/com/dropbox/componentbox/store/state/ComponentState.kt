package com.dropbox.componentbox.store.state

import com.dropbox.componentbox.data.entities.Node
import com.dropbox.componentbox.models.Component

data class ComponentState(
    var nodes: MutableList<Node> = mutableListOf(),
    var idToComponent: MutableMap<String, Component> = mutableMapOf(),
    var activeNode: Node? = null,
    var rootComponents: MutableList<Component> = mutableListOf()
)