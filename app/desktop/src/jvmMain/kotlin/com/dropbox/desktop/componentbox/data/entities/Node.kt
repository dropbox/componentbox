package com.dropbox.desktop.componentbox.data.entities

import com.dropbox.componentbox.foundation.ComponentType

data class Node(
    val id: String,
    val path: String,
    val type: ComponentType,
    var children: MutableList<Node>
)