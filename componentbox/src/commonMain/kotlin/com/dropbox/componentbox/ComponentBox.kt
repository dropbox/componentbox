package com.dropbox.componentbox

import com.dropbox.componentbox.component.Component

interface ComponentBox {
    val value: Component.Box

    interface Event {
        sealed interface Data<out Key: Any> {
            val key: Key
            interface Write<Key: Any>: Data<Key> {
                val input: ComponentBox
            }
            interface Read<Key: Any>: Data<Key>
        }
    }
    interface Navigation
}