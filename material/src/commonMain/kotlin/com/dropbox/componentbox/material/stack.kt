package com.dropbox.componentbox.material

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.component.Stack
import com.dropbox.componentbox.ui.ComponentBoxKit

@Composable
internal fun Stack.stack(kit: ComponentBoxKit) {
    Box(modifier = kit.modifierTransformer(modifier)) {
        components?.forEach { component ->
            component.material(kit)
        }
    }
}