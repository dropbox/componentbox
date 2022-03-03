package com.dropbox.componentbox.samples.discovery.row

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.build
import com.dropbox.componentbox.horizontal
import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.samples.discovery.Inflate
import com.dropbox.componentbox.vertical

@Composable
fun Component.Row.Inflate() {
    when (this.isLazy) {
        true -> this.LazyRow()
        else -> this.Row()
    }
}

@Composable
fun Component.Row.Row() {
    val components = this.components
    Row(
        verticalAlignment = verticalAlignment.vertical(),
        horizontalArrangement = horizontalArrangement.horizontal(),
        modifier = modifier.build()
    ) {
        components?.forEach { component ->
            component.Inflate()
        }
    }
}

@Composable
fun Component.Row.LazyRow() {
    val components = this.components
    LazyRow(
        verticalAlignment = verticalAlignment.vertical(),
        horizontalArrangement = horizontalArrangement.horizontal(),
        modifier = modifier.build()
    ) {
        if (components != null) {
            items(components) { component ->
                component.Inflate()
            }
        }
    }
}
