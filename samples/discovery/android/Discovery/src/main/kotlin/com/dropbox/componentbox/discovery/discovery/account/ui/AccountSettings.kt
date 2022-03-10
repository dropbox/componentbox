package com.dropbox.componentbox.discovery.discovery.account.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.discovery.theme.R
import com.dropbox.componentbox.samples.discovery.color.faintText
import com.dropbox.componentbox.samples.discovery.color.standardBackgroundElevated
import com.dropbox.componentbox.samples.discovery.color.standardText

@Composable
fun AccountSettings() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
    ) {
        Text(
            text = "Settings",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
        )

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
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = null,
                tint = MaterialTheme.colors.standardText,
                modifier = Modifier.size(24.dp)
            )

            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(text = title, style = MaterialTheme.typography.body1)
                Text(text = caption, style = MaterialTheme.typography.body2, color = MaterialTheme.colors.faintText)
            }
        }

        if (label != null) {
            Text(text = label, style = MaterialTheme.typography.body1, color = MaterialTheme.colors.faintText)
        }

    }
}