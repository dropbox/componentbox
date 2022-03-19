package com.dropbox.componentbox.foundation

import androidx.compose.runtime.Composable

actual interface Inflater {
    @Composable
    fun Inflate(component: Component)

    @Composable
    fun bottomTabs(): List<BottomTab>
}