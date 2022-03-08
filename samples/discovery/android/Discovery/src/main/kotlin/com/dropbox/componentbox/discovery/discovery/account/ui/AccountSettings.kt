package com.dropbox.componentbox.discovery.discovery.account.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.discovery.theme.R
import com.dropbox.componentbox.samples.discovery.color.faintText
import com.dropbox.componentbox.samples.discovery.color.standardText

@Composable
fun AccountSettings() {
    Column(modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colors.background)) {
        Text(text = "Settings", style = MaterialTheme.typography.h6)

        AccountSetting(
            icon = R.drawable.ic_dig_camera_line,
            title = "Camera uploads",
            caption = "Automatically upload your device's photos",
            label = "Off"
        )

        AccountSetting(
            icon = R.drawable.ic_dig_computer_line,
            title = "Connect a computer",
            caption = "Easily install the Dropbox desktop application",
        )
    }
}


@Composable
fun AccountSetting(
    @DrawableRes icon: Int,
    title: String,
    caption: String,
    label: String? = null
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = MaterialTheme.colors.standardText,
                modifier = Modifier.size(24.dp)
            )

            Column {
                Text(text = title, style = MaterialTheme.typography.body2)
                Text(text = caption, style = MaterialTheme.typography.caption, color = MaterialTheme.colors.faintText)
            }
        }

        if (label != null) {
            Text(text = label, style = MaterialTheme.typography.body1, color = MaterialTheme.colors.faintText)
        }

    }
}