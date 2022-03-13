package com.dropbox.componentbox.utils

import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Margin
import com.dropbox.componentbox.foundation.Padding

internal fun Component?.margin() = when (this) {
    is Component.Box -> this.modifier?.margin ?: Margin()
    is Component.Button -> this.modifier?.margin ?: Margin()
    is Component.Column -> this.modifier?.margin ?: Margin()
    is Component.Drawable -> this.modifier?.margin ?: Margin()
    is Component.Row -> this.modifier?.margin ?: Margin()
    is Component.Switch -> this.modifier?.margin ?: Margin()
    is Component.Text -> this.modifier?.margin ?: Margin()
    is Component.Vector -> this.modifier?.margin ?: Margin()
    is Component.Surface -> this.modifier?.margin ?: Margin()
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
    is Component.Surface -> this.modifier?.padding ?: Padding()
    else -> Padding()
}