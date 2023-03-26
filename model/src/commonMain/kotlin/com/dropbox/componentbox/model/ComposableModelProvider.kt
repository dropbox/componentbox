package com.dropbox.componentbox.model

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf

class ComposableModelProvider {
    val modelMap = mutableMapOf<String, ComposableModel<*, *>>()

    inline fun <reified T : ComposableModel<*, *>> getOrCreateModel(crossinline creator: () -> T): T {
        val key = requireNotNull(T::class.simpleName)
        return modelMap.getOrPut(key) { creator() } as T
    }
}

val LocalComposableModelProvider = staticCompositionLocalOf { ComposableModelProvider() }


@Composable
inline fun <reified T : ComposableModel<*, *>> composableModel(): T {
    val factory = LocalComposableModelFactory.current as? ComposableModelFactory<T>
        ?: error("No factory provided for creating a ComposableModel of type ${T::class.simpleName}")

    val provider = LocalComposableModelProvider.current
    return remember { provider.getOrCreateModel(factory::create) }
}