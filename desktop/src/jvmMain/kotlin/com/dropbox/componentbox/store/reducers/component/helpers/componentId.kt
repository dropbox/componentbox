package com.dropbox.componentbox.store.reducers.component.helpers

import com.dropbox.componentbox.models.Component

internal fun Component?.componentId() = when (this) {
    is Component.Box -> this.id
    is Component.Button -> this.id
    is Component.Column -> this.id
    is Component.Drawable -> this.id
    is Component.Row -> this.id
    is Component.Switch -> this.id
    is Component.Text -> this.id
    is Component.Vector -> this.id
    else -> null
}