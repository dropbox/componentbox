package com.dropbox.desktop.componentbox.store.reducers.component.helpers

import com.dropbox.componentbox.foundation.Component

internal fun Component?.componentId() = when (this) {
    is Component.Box -> this.id
    is Component.Button -> this.id
    is Component.Column -> this.id
    is Component.Drawable -> this.id
    is Component.Row -> this.id
    is Component.Switch -> this.id
    is Component.Text -> this.id
    is Component.Vector -> this.id
    is Component.Surface -> this.id
    else -> null
}