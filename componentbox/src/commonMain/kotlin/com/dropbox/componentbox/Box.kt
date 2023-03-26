package com.dropbox.componentbox

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

sealed class Box : Component {

    abstract val modifier: Modifier
    abstract val children: MutableList<Component>

    @Serializable
    class Static<Event : Any>(
        override val modifier: Modifier = Modifier(),
        val events: Events.Semantic<Event>? = null,
        override val children: MutableList<Component> = mutableListOf()
    ) : Box() {
        fun child(component: Component) {
            children.add(component)
        }
    }

    class Dynamic(
        override val modifier: Modifier = Modifier(),
        val events: Events.Lambda? = null,
        override val children: MutableList<Component> = mutableListOf()
    ) : Box() {
        @Composable
        fun child(component: Component) {
            children.add(component)
        }
    }


}