package com.dropbox.componentbox

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
class Column(
    val modifier: Modifier,
    val events: Events? = null,
    val verticalArrangement: Arrangement.Vertical? = null,
    val horizontalAlignment: Alignment.Horizontal? = null,
    val children: MutableList<Component> = mutableListOf()
) : Component {
    @Composable
    fun child(component: Component) {
        children.add(component)
    }
}