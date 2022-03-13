package com.dropbox.componentbox.utils

import com.dropbox.componentbox.data.entities.Node
import com.dropbox.componentbox.foundation.ComponentType

internal fun ComponentType.node() = Node(id = id(), path = "", type = this, children = mutableListOf())
