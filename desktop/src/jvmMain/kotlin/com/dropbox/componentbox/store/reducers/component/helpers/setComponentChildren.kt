package com.dropbox.componentbox.store.reducers.component.helpers

import com.dropbox.componentbox.models.Component

internal fun Component?.setComponentChildren(children: MutableList<Component>) {
    apply {
        when (this) {
            is Component.Box -> components = children
            is Component.Button -> components = children
            is Component.Column -> components = children
            is Component.Row -> components = children
            else -> {}
        }
    }
}