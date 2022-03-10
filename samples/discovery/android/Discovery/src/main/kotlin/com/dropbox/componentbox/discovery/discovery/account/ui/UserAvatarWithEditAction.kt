package com.dropbox.componentbox.discovery.discovery.account.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.discovery.theme.R

@Composable
fun UserAvatarWithEditAction(url: String, contentDescription: String? = null) {
    Box(modifier = Modifier.size(80.dp)) {
        Image(
            painter = painterResource(id = R.drawable.tag),
            contentScale = ContentScale.Crop,
            contentDescription = contentDescription,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {

            Surface(color = MaterialTheme.colors.background, elevation = 2.dp, shape = CircleShape) {
                IconButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .padding(2.dp)
                        .background(MaterialTheme.colors.background)
                        .padding(2.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_dig_edit_line),
                        contentDescription = null,
                    )
                }
            }
        }

    }
}