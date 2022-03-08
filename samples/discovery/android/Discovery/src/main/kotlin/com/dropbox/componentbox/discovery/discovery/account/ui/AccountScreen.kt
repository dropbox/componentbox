package com.dropbox.componentbox.discovery.discovery.account.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.dropbox.componentbox.discovery.discovery.scaffold.ScaffoldCallback
import com.dropbox.componentbox.discovery.theme.R
import com.dropbox.componentbox.samples.discovery.color.standardBackgroundElevated
import com.dropbox.componentbox.samples.discovery.color.standardText

@Composable
fun AccountScreen(callback: ScaffoldCallback) {
    callback.setTitle("Account")
    callback.setTopBarActions(listOf {
        GearIcon()
    })

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.standardBackgroundElevated),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        item {
            Row(modifier = Modifier.fillMaxWidth()) {
                AccountInfo()
            }
        }


        item {
            Row(modifier = Modifier.fillMaxWidth()) {
                AccountDetails()
            }
        }

        item {
            Row(modifier = Modifier.fillMaxWidth()) {
                AccountFeatures()
            }
        }

        item {
            Row(modifier = Modifier.fillMaxWidth()) {
                AccountSettings()
            }
        }
    }
}


@Composable
fun GearIcon() {
    IconButton(onClick = { /*TODO*/ }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_dig_settings_line),
            contentDescription = null,
            tint = MaterialTheme.colors.standardText,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun AccountInfo() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Row(verticalAlignment = Alignment.CenterVertically) {


            UserAvatarWithEditAction(FAKE_AVATAR_URL, FAKE_CONTENT_DESCRIPTION)


            Box(modifier = Modifier.padding(start = 16.dp)) {
                UserNameAndEmail(name = FAKE_NAME, email = FAKE_EMAIL)
            }

        }


        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_dig_switcher_line),
                contentDescription = null,
                tint = MaterialTheme.colors.standardText
            )
        }


    }
}


@Composable
fun UserAvatarWithEditAction(url: String, contentDescription: String? = null) {
    Box(modifier = Modifier.size(80.dp)) {
        Image(
            painter = rememberImagePainter(url),
            contentScale = ContentScale.Crop,
            contentDescription = contentDescription,
            modifier = Modifier
                .size(80.dp)
                .clip(CircleShape)
                .shadow(16.dp, CircleShape)
        )

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {

            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .size(24.dp)
                    .clip(CircleShape)
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

@Composable
fun UserNameAndEmail(name: String, email: String) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(text = name, style = MaterialTheme.typography.h6)
        Text(text = email, style = MaterialTheme.typography.body2)
    }
}

private const val FAKE_AVATAR_URL =
    "https://raw.githubusercontent.com/dropbox/componentbox/master/desktop/src/jvmMain/resources/tag.jpeg"
private const val FAKE_CONTENT_DESCRIPTION = "tag"
private const val FAKE_NAME = "Tag Ramotar"
private const val FAKE_EMAIL = "tag@dropbox.com"