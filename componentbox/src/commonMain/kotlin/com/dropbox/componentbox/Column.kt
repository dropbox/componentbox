package com.dropbox.componentbox

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable


@Serializable
sealed class Column : Component {
    abstract val modifier: Modifier
    abstract val verticalArrangement: Arrangement.Vertical?
    abstract val horizontalAlignment: Alignment.Horizontal?
    abstract val children: MutableList<Component>

    @Serializable
    class Static<Event : Any>(
        override val modifier: Modifier = Modifier(),
        val events: Events.Semantic<Event>? = null,
        override val verticalArrangement: Arrangement.Vertical? = null,
        override val horizontalAlignment: Alignment.Horizontal? = null,
        override val children: MutableList<Component> = mutableListOf()
    ) : Column() {
        fun child(component: Component) {
            children.add(component)
        }
    }

    class Dynamic(
        override val modifier: Modifier = Modifier(),
        val events: Events.Lambda? = null,
        override val verticalArrangement: Arrangement.Vertical? = null,
        override val horizontalAlignment: Alignment.Horizontal? = null,
        override val children: MutableList<Component> = mutableListOf()
    ) : Column() {
        @Composable
        fun child(component: Component) {
            children.add(component)
        }
    }


}