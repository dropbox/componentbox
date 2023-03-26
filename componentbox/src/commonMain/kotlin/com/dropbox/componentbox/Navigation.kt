package com.dropbox.componentbox

import kotlinx.serialization.Serializable

@Serializable
class Navigation<Route : Any>(
    private val routes: Routes<Route> = mutableMapOf(),
    val start: String,
) : Component {

    fun route(id: Route, component: Component) {
        routes[id] = component
    }
}

