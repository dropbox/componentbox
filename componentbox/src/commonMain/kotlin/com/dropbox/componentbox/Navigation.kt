package com.dropbox.componentbox

import kotlinx.serialization.Serializable

@Serializable
class Navigation<Route : Any>(
    private val routes: Routes<Route> = mutableMapOf(),
    val start: String,
) : Forest {

    fun route(id: Route, component: Tree) {
        routes[id] = component
    }
}

