package com.dropbox.componentbox.discovery.discovery.account.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import com.dropbox.componentbox.discovery.theme.R

@Composable
fun AlsoFromDropbox() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
    ) {
        Text(
            text = "Also from Dropbox",
            style = MaterialTheme.typography.h6,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 16.dp)
        )


        LazyRow {
            items(1) {
                DropboxFeatureCard(
                    image = R.drawable.van_cityscape,
                    icon = R.drawable.ic_dig_dropbox_passwords_line,
                    title = "Dropbox Passwords",
                    caption = "Sign in anywhere with Windows, Mac, iOS, and Android",
                    chipLabels = listOf("Premium")
                )

                DropboxFeatureCard(
                    image = R.drawable.travel_backpack,
                    icon = R.drawable.ic_dig_dropbox_backup_line,
                    title = "Dropbox Backup",
                    caption = "Backup your Mac or PC folders, including Desktop, Documents and Downloads",
                    chipLabels = listOf("Premium")
                )
            }
        }
    }
}

@Composable
fun DropboxFeatureCard(
    @DrawableRes image: Int,
    @DrawableRes icon: Int,
    title: String,
    caption: String,
    chipLabels: List<String>
) {
    Surface(
        shape = RoundedCornerShape(4.dp),
        elevation = 2.dp,
        modifier = Modifier
            .padding(8.dp)
            .width(200.dp)
            .heightIn(min = 200.dp)
            .padding(8.dp)
    ) {
        Column {
            Box {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier.height(100.dp),
                    contentScale = ContentScale.FillWidth
                )


                Surface(
                    elevation = 1.dp,
                    shape = CircleShape,
                    modifier = Modifier
                        .padding(6.dp)
                        .offset(x = 2.dp, y = 80.dp),
                    color = MaterialTheme.colors.background
                ) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = null,
                        modifier = Modifier.zIndex(100.0f)
                    )
                }

            }

            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = title, style = MaterialTheme.typography.body1)

                Text(text = caption, style = MaterialTheme.typography.caption)
            }


            Row {
                chipLabels.forEach { chipLabel ->
                    Surface(
                        modifier = Modifier
                            .padding(4.dp),
                        shape = RoundedCornerShape(16.dp),
                        color = MaterialTheme.colors.primary
                    ) {

                        Text(
                            text = chipLabel,
                            color = MaterialTheme.colors.onPrimary,
                            style = MaterialTheme.typography.caption,
                            modifier = Modifier.padding(4.dp)
                        )

                    }
                }
            }
        }

    }
}