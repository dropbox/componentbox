package com.dropbox.componentbox.data.entities

import com.dropbox.componentbox.models.Component

data class ChildAndParentComponent(
    val child: Component,
    val parent: Component?
)