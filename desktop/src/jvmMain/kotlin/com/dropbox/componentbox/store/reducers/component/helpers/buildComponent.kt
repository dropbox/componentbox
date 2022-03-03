package com.dropbox.componentbox.store.reducers.component.helpers

import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.models.ComponentType
import com.dropbox.componentbox.models.Modifier

internal fun ComponentType.build(id: String): Component {
    return when (this) {
        ComponentType.Box -> Component.Box(id, modifier = Modifier())
        ComponentType.Button -> Component.Button(id, modifier = Modifier())
        ComponentType.Column -> Component.Column(id, modifier = Modifier())
        ComponentType.Drawable -> Component.Drawable(id, modifier = Modifier())
        ComponentType.LazyColumn -> Component.Column(id, isLazy = true, modifier = Modifier())
        ComponentType.LazyRow -> Component.Row(id, isLazy = true, modifier = Modifier())
        ComponentType.Row -> Component.Row(id, modifier = Modifier())
        ComponentType.Switch -> Component.Switch(id, modifier = Modifier())
        ComponentType.Table -> Component.Column(id, isLazy = true, isTable = true, modifier = Modifier())
        ComponentType.Text -> Component.Text(id, modifier = Modifier())
        ComponentType.Vector -> Component.Vector(id, modifier = Modifier())
    }
}