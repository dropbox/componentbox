package com.dropbox.componentbox.samples.discovery.column

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dropbox.componentbox.util.build
import com.dropbox.componentbox.util.compose
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.util.horizontal
import com.dropbox.componentbox.samples.discovery.Inflate
import com.dropbox.componentbox.util.vertical

@Composable
fun Component.Column.Inflate() {
    when (this.isLazy) {
        true -> this.LazyColumn()
        else -> this.Column()
    }
}

@Composable
fun Component.Column.Column() {
    val components = components

    val backgroundColor = modifier?.background.compose()
    val customModifiers = if (backgroundColor != null) {
        listOf(Modifier.background(backgroundColor))
    } else {
        listOf()
    }

    Column(
        verticalArrangement = verticalArrangement.vertical(),
        horizontalAlignment = horizontalAlignment.horizontal(),
        modifier = modifier.build(customModifiers)
    ) {
        components?.forEach { component ->
            component.Inflate()
        }
    }
}

@Composable
fun Component.Column.LazyColumn() {
    val components = components

    val backgroundColor = modifier?.background.compose()
    val customModifiers = if (backgroundColor != null) {
        listOf(Modifier.background(backgroundColor))
    } else {
        listOf()
    }

    LazyColumn(
        verticalArrangement = verticalArrangement.vertical(),
        horizontalAlignment = horizontalAlignment.horizontal(),
        modifier = modifier.build(customModifiers)
    ) {
        if (components != null) {
            items(components) { component ->
                component.Inflate()
            }
        }
    }
}