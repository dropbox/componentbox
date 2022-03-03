package com.dropbox.componentbox.util

import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.models.Margin
import com.dropbox.componentbox.models.Padding

internal fun Component?.margin() = when (this) {
    is Component.Box -> this.modifier?.margin ?: Margin()
    is Component.Button -> this.modifier?.margin ?: Margin()
    is Component.Column -> this.modifier?.margin ?: Margin()
    is Component.Drawable -> this.modifier?.margin ?: Margin()
    is Component.Row -> this.modifier?.margin ?: Margin()
    is Component.Switch -> this.modifier?.margin ?: Margin()
    is Component.Text -> this.modifier?.margin ?: Margin()
    is Component.Vector -> this.modifier?.margin ?: Margin()
    else -> Margin()
}

internal fun Component?.padding() = when (this) {
    is Component.Box -> this.modifier?.padding ?: Padding()
    is Component.Button -> this.modifier?.padding ?: Padding()
    is Component.Column -> this.modifier?.padding ?: Padding()
    is Component.Drawable -> this.modifier?.padding ?: Padding()
    is Component.Row -> this.modifier?.padding ?: Padding()
    is Component.Switch -> this.modifier?.padding ?: Padding()
    is Component.Text -> this.modifier?.padding ?: Padding()
    is Component.Vector -> this.modifier?.padding ?: Padding()
    else -> Padding()
}