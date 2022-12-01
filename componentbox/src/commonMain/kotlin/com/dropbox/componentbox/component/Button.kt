package com.dropbox.componentbox.component

sealed interface Button : Component {
    var components: MutableList<Component>?
    var disabled: Boolean?
}