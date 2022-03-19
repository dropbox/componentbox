package com.dropbox.componentbox.material.row

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.foundation.Context
import com.dropbox.componentbox.material.Inflate
import com.dropbox.componentbox.util.build
import com.dropbox.componentbox.util.horizontal
import com.dropbox.componentbox.util.vertical

// This module targets JS
// Until material and foundation are supported on JS
// Changes to this file should be duplicated in jvmMain
// TODO(https://github.com/dropbox/componentbox/issues/25)

@Composable
fun Component.Row.Inflate(context: Context?) {
    when (this.isLazy) {
        true -> this.LazyRow(context)
        else -> this.Row(context)
    }
}

@Composable
private fun Component.Row.Row(context: Context?) {
    val backgroundColor = context?.themer?.getColorResId(modifier?.background)

    val customModifiers = if (backgroundColor != null) {
        listOf(Modifier.background(Color(backgroundColor)))
    } else {
        listOf()
    }

    Row(
        verticalAlignment = verticalAlignment.vertical(),
        horizontalArrangement = horizontalArrangement.horizontal(),
        modifier = modifier.build(customModifiers)
    ) {
        components?.forEach { component ->
            component.Inflate()
        }
    }
}

@Composable
private fun Component.Row.LazyRow(context: Context?) {
    val backgroundColor = context?.themer?.getColorResId(modifier?.background)

    val customModifiers = if (backgroundColor != null) {
        listOf(Modifier.background(Color(backgroundColor)))
    } else {
        listOf()
    }

    LazyRow(
        verticalAlignment = verticalAlignment.vertical(),
        horizontalArrangement = horizontalArrangement.horizontal(),
        modifier = modifier.build(customModifiers)
    ) {
        if (components != null) {
            items(components!!) { component ->
                component.Inflate()
            }
        }
    }
}
