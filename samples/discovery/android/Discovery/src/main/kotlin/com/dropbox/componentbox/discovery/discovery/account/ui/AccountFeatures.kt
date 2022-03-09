package com.dropbox.componentbox.discovery.discovery.account.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.discovery.theme.R
import com.dropbox.componentbox.samples.discovery.color.standardBackgroundElevated
import com.dropbox.componentbox.samples.discovery.color.standardText

@Composable
fun AccountFeatures() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
    ) {
        Text(
            text = "Your features",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
        )

        AccountFeature(
            iconStart = R.drawable.ic_dig_syncing_line,
            title = "Sync",
            caption = "All your content everywhere",
            iconEnd = R.drawable.ic_dig_arrow_right_line,
            contentColor = MaterialTheme.colors.standardText
        )

        AccountFeature(
            iconStart = R.drawable.ic_dig_scan_line,
            title = "Doc scanner",
            caption = "Scan receipts and documents",
            iconEnd = R.drawable.ic_dig_arrow_right_line,
            contentColor = MaterialTheme.colors.standardText
        )

        AccountFeature(
            iconStart = R.drawable.ic_dig_member_transfer_line,
            title = "Transfer",
            caption = "Send large files securely",
            iconEnd = R.drawable.ic_dig_arrow_right_line,
            contentColor = MaterialTheme.colors.standardText
        )

        AccountFeature(
            iconStart = R.drawable.ic_dig_twinkle_2_line,
            title = "Explore",
            caption = "Explore Plus features",
            iconEnd = R.drawable.ic_dig_arrow_right_line,
            contentColor = MaterialTheme.colors.primary
        )
    }
}

@Composable
fun AccountFeature(
    @DrawableRes iconStart: Int,
    title: String,
    caption: String,
    @DrawableRes iconEnd: Int,
    contentColor: Color
) {

    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colors.standardBackgroundElevated)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Row {
            Icon(
                painter = painterResource(id = iconStart),
                contentDescription = null,
                tint = contentColor,
                modifier = Modifier.size(24.dp)
            )

            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(text = title, style = MaterialTheme.typography.body1, color = contentColor)
                Text(text = caption, style = MaterialTheme.typography.body2, color = contentColor)
            }
        }



        Icon(
            painter = painterResource(id = iconEnd),
            contentDescription = null,
            tint = contentColor,
            modifier = Modifier.size(24.dp)
        )

    }
}