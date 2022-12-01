package com.dropbox.componentbox

import com.dropbox.componentbox.component.Component
import com.dropbox.componentbox.impl.ComponentBoxComponentBox

interface ComponentBox {
    val root: Component.Box

    companion object {
        fun of(root: Component.Box): ComponentBox = ComponentBoxComponentBox(root)
    }
}