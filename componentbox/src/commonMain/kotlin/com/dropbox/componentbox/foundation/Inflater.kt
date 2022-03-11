package com.dropbox.componentbox.foundation

import androidx.compose.runtime.Composable

interface Inflater {
    @Composable
    fun Inflate(component: Component)

    @Composable
    fun bottomTabs(): List<BottomTab>
}