package com.dropbox.componentbox.model

import androidx.compose.runtime.compositionLocalOf

interface ComposableModelFactory<T : ComposableModel<*, *>> {
    fun create(): T
}

val LocalComposableModelFactory = compositionLocalOf<ComposableModelFactory<*>?> { null }
