package com.dropbox.desktop.componentbox.ui.surfaces.toolbar

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BasicToolbarButton(
    iconResourcePath: String,
    contentDescription: String? = null,
    tint: Color = MaterialTheme.colors.onBackground,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    IconButton(onClick = onClick) {
        Icon(
            painter = painterResource(iconResourcePath),
            contentDescription = contentDescription,
            tint = tint,
            modifier = modifier.then(Modifier.size(32.dp))
        )
    }
}