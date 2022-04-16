package com.dropbox.desktop.componentbox.util

import com.dropbox.desktop.componentbox.data.entities.Node
import com.dropbox.componentbox.foundation.ComponentType

internal fun ComponentType.node() = Node(id = id(), path = "", type = this, children = mutableListOf())
