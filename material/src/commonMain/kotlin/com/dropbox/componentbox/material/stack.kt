package com.dropbox.componentbox.material

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.component.Stack
import com.dropbox.componentbox.kit.ComponentBoxKit

@Composable
internal fun Stack.stack(kit: ComponentBoxKit) {
    Box(modifier = kit.converter.modifier(modifier)) {
        components?.forEach { component ->
            component.material(kit)
        }
    }
}