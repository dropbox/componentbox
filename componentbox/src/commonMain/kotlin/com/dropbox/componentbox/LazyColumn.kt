package com.dropbox.componentbox

import androidx.compose.runtime.Composable


sealed class LazyColumn : Component {
    abstract val modifier: Modifier
    abstract val events: Events?
    abstract val verticalArrangement: Arrangement.Vertical?
    abstract val horizontalAlignment: Alignment.Horizontal?
    abstract val contentPadding: PaddingValues?
    abstract val children: MutableList<Component>

    data class Dynamic(
        override val modifier: Modifier = Modifier(),
        override val events: Events.Lambda? = null,
        override val verticalArrangement: Arrangement.Vertical? = null,
        override val horizontalAlignment: Alignment.Horizontal? = null,
        override val contentPadding: PaddingValues? = null,
        override val children: MutableList<Component> = mutableListOf()
    ) : LazyColumn() {
        @Composable
        fun child(component: Component) {
            children.add(component)
        }
    }

    data class Static<Event : Any>(
        override val modifier: Modifier = Modifier(),
        override val events: Events.Semantic<Event>? = null,
        override val verticalArrangement: Arrangement.Vertical? = null,
        override val horizontalAlignment: Alignment.Horizontal? = null,
        override val contentPadding: PaddingValues? = null,
        override val children: MutableList<Component> = mutableListOf()
    ) : LazyColumn() {
        fun child(component: Component) {
            children.add(component)
        }
    }
}