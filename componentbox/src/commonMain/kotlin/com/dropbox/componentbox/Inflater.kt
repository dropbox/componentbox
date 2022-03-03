package com.dropbox.componentbox

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.models.BottomTab
import com.dropbox.componentbox.models.Component

interface Inflater {
    @Composable
    fun Inflate(component: Component)

    @Composable
    fun bottomTabs(): List<BottomTab>
}