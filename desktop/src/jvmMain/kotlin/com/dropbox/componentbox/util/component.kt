package com.dropbox.componentbox.util

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Inflater
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.ComponentType
import com.dropbox.componentbox.store.state.ComponentState

internal fun ComponentType.iconResourcePath() = when (this) {
    ComponentType.Row,
    ComponentType.LazyRow,
    ComponentType.Column,
    ComponentType.LazyColumn,
    ComponentType.Box -> "drawable/ic_dig_square_line.xml"
    ComponentType.Text -> "drawable/ic_dig_h1_line.xml"
    ComponentType.Button -> "drawable/ic_dig_activity_line.xml"
    ComponentType.Drawable,
    ComponentType.Vector -> "drawable/ic_dig_image_line.xml"
    ComponentType.Switch,
    ComponentType.Table -> "drawable/ic_dig_table_line.xml"
}

internal fun ComponentState.getComponentById(id: String?) = idToComponent[id]

@Composable
internal fun Component.inflate(inflater: Inflater) = inflater.Inflate(this)

internal fun Component.copy(): Component = when (this) {
    is Component.Box -> copy(components = components?.copy(), modifier = this.modifier!!.copy())
    is Component.Button -> copy(components = components?.copy(), modifier = this.modifier!!.copy())
    is Component.Column -> copy(components = components?.copy(), modifier = this.modifier!!.copy())
    is Component.Drawable -> copy(modifier = this.modifier!!.copy())
    is Component.Row -> copy(components = components?.copy(), modifier = this.modifier!!.copy())
    is Component.Switch -> copy(modifier = this.modifier!!.copy())
    is Component.Text -> copy(modifier = this.modifier!!.copy())
    is Component.Vector -> copy(modifier = this.modifier!!.copy())
}

internal fun MutableList<Component>.copy(): MutableList<Component> = this.map { it.copy() }.toMutableList()