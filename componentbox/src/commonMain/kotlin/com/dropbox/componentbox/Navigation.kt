package com.dropbox.componentbox

class Navigation(
    val routes: MutableMap<String, Component> = mutableMapOf(),
    val start: String,
) : Component {
    fun route(name: String, component: Component) {
        routes[name] = component
    }
}