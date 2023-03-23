package com.dropbox.componentbox

class LazyColumn(
    val modifier: Modifier,
    val events: Events? = null,
    val verticalArrangement: Arrangement.Vertical? = null,
    val horizontalAlignment: Alignment.Horizontal? = null,
    val contentPadding: PaddingValues? = null,
    val children: MutableList<Component> = mutableListOf()
) : Component {
    fun child(component: Component) {
        children.add(component)
    }
}