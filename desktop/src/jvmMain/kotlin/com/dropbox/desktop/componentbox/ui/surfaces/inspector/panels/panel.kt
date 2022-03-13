package com.dropbox.desktop.componentbox.ui.surfaces.inspector.panels

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dropbox.desktop.componentbox.ui.theme.inverseStandardBackground

@Composable
fun panel(title: String, content: @Composable () -> Unit) {

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = title,
                color = MaterialTheme.colors.inverseStandardBackground
            )
        }

        content()
    }
}