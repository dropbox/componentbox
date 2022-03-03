package com.dropbox.componentbox

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.models.Colors
import com.dropbox.componentbox.models.Icons
import com.dropbox.componentbox.models.Images
import com.dropbox.componentbox.models.Typography

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