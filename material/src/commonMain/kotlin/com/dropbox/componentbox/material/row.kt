package com.dropbox.componentbox.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.dropbox.componentbox.component.LazyRow
import com.dropbox.componentbox.component.Row
import com.dropbox.componentbox.ui.ComponentBoxKit

@Composable
internal fun Row.row(kit: ComponentBoxKit) {
    when (this) {
        is LazyRow -> {
            LazyRow(
                modifier = kit.modifierTransformer(modifier),
                verticalAlignment = kit.verticalAlignmentTransformer(this.verticalAlignment) ?: Alignment.Top,
                horizontalArrangement = kit.horizontalArrangementTransformer(this.horizontalArrangement)
                    ?: Arrangement.Start
            ) {
                if (components != null) {
                    items(components!!) { component ->
                        component.material(kit)
                    }
                }
            }
        }

        else -> Row(
            modifier = kit.modifierTransformer(modifier),
            verticalAlignment = kit.verticalAlignmentTransformer(this.verticalAlignment) ?: Alignment.Top,
            horizontalArrangement = kit.horizontalArrangementTransformer(this.horizontalArrangement)
                ?: Arrangement.Start
        ) {
            components?.forEach { component ->
                component.material(kit)
            }
        }
    }
}