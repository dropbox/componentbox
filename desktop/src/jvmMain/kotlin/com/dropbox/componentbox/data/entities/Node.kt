package com.dropbox.componentbox.data.entities

import com.dropbox.componentbox.models.ComponentType

data class Node(
    val id: String,
    val path: String,
    val type: ComponentType,
    var children: MutableList<Node>
)