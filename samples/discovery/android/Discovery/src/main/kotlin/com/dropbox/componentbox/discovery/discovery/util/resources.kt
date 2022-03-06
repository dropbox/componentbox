package com.dropbox.componentbox.discovery.discovery.util

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

fun Int.icon(size: Int = 28): @Composable () -> Unit {
    return {
        Icon(painter = painterResource(id = this), contentDescription = null, modifier = Modifier.size(size.dp))
    }
}