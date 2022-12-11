package com.dropbox.componentbox.material

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.dropbox.componentbox.component.Column
import com.dropbox.componentbox.component.LazyColumn
import com.dropbox.componentbox.kit.ComponentBoxKit

@Composable
internal fun Column.column(kit: ComponentBoxKit) {
    when (this) {
        is LazyColumn -> {
            LazyColumn(
                modifier = kit.converter.modifier(modifier),
                verticalArrangement = kit.converter.verticalArrangement(this.verticalArrangement) ?: Arrangement.Top,
                horizontalAlignment = kit.converter.horizontalAlignment(this.horizontalAlignment) ?: Alignment.Start
            ) {
                if (components != null) {
                    items(components!!) { component ->
                        component.material(kit)
                    }
                }
            }
        }

        else -> Column(
            modifier = kit.converter.modifier(modifier),
            verticalArrangement = kit.converter.verticalArrangement(this.verticalArrangement) ?: Arrangement.Top,
            horizontalAlignment = kit.converter.horizontalAlignment(this.horizontalAlignment) ?: Alignment.Start
        ) {
            components?.forEach { component ->
                component.material(kit)
            }
        }
    }
}
