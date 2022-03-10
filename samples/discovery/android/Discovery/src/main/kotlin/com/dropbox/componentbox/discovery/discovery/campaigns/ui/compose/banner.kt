package com.dropbox.componentbox.discovery.discovery.campaigns.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.Campaign
import com.dropbox.componentbox.discovery.discovery.campaigns.data.run
import com.dropbox.componentbox.discovery.theme.R

@Composable
fun Campaign.Banner.PromptBanner.Inflate(onDismiss: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFEBF2FF))
            .padding(vertical = 12.dp, horizontal = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_dig_camera_upload_line),
            contentDescription = null,
            modifier = Modifier.size(32.dp)
        )

        Column() {
            Text(text = "Turn on camera uploads", style = MaterialTheme.typography.h6)
            Text(text = "Keep all your photos safe and sound", style = MaterialTheme.typography.body2)
        }

        IconButton(onClick = {
            action.run()
            onDismiss()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_dig_arrow_right_line),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                tint = MaterialTheme.colors.primary
            )
        }
    }
}


@Composable
fun Campaign.Banner.PromptBigBanner.Inflate(onDismiss: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFEF4D4))
    ) {

        Box {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                IconButton(onClick = onDismiss) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_dig_close_line),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Image(
                painter = rememberImagePainter(imageUrl),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.onBackground)
                .padding(horizontal = 16.dp)

        ) {
            Text(
                text = text,
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.background
            )

            Text(
                text = subtext,
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(vertical = 4.dp),
                color = MaterialTheme.colors.background
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Button(
                    onClick = { onDismiss() },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                    modifier = Modifier
                        .padding(end = 2.dp)
                        .fillMaxWidth(),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Text(
                        text = confirmText,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp),
                        color = MaterialTheme.colors.background,
                        style = MaterialTheme.typography.button,
                    )
                }
            }
        }

    }
}