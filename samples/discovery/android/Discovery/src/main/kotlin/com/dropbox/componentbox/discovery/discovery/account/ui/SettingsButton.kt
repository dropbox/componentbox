package com.dropbox.componentbox.discovery.discovery.account.ui

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.discovery.theme.R
import com.dropbox.componentbox.samples.discovery.color.standardText

@Composable
fun SettingsButton() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_dig_settings_line),
            contentDescription = null,
            tint = MaterialTheme.colors.standardText,
            modifier = Modifier.size(32.dp)
        )
    }
}