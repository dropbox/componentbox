package com.dropbox.componentbox

import kotlinx.serialization.Polymorphic

@Polymorphic
interface Tree {
    val root: Component
}