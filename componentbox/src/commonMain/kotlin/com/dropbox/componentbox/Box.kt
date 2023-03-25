package com.dropbox.componentbox

import kotlinx.serialization.Serializable

@Serializable
class Box(
    val modifier: Modifier,
    val events: Events? = null,
    val children: MutableList<Component> = mutableListOf()
) : Component {
    fun child(component: Component) {
        children.add(component)
    }
}