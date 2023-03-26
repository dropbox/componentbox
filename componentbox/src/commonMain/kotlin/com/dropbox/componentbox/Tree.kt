package com.dropbox.componentbox

import androidx.compose.runtime.Composable
import kotlinx.serialization.Polymorphic

@Polymorphic
interface Tree {
    val root: Component
        @Composable
        get
}