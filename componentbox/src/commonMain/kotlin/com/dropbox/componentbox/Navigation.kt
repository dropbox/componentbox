package com.dropbox.componentbox

import kotlinx.serialization.Serializable

@Serializable
class Navigation(
    val routes: MutableMap<String, Component> = mutableMapOf(),
    val start: String,
) : Component {
    fun route(name: String, component: Component) {
        routes[name] = component
    }
}