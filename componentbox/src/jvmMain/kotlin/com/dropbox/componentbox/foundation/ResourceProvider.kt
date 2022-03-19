package com.dropbox.componentbox.foundation

import androidx.compose.runtime.Composable

interface ResourceProvider {
    @Composable
    fun icons(): Icons

    @Composable
    fun images(): Images

    @Composable
    fun typography(): Typography

    @Composable
    fun colors(): Colors
}