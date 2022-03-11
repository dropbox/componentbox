package com.dropbox.componentbox.data.entities

import com.dropbox.componentbox.foundation.Component

data class ChildAndParentComponent(
    val child: Component,
    val parent: Component?
)