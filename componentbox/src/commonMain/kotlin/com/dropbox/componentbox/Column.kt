package com.dropbox.componentbox

class Column(
    val modifier: Modifier,
    val events: Events? = null,
    val verticalArrangement: Arrangement.Vertical? = null,
    val horizontalAlignment: Alignment.Horizontal? = null,
    val children: MutableList<Component> = mutableListOf()
) : Component {
    fun child(component: Component) {
        children.add(component)
    }
}