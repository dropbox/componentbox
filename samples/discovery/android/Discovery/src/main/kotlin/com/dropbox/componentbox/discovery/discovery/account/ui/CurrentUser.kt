package com.dropbox.componentbox.discovery.discovery.account.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.discovery.theme.R
import com.dropbox.componentbox.samples.discovery.color.standardText

@Composable
fun CurrentUser() {
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

private const val FAKE_AVATAR_URL =
    "https://raw.githubusercontent.com/dropbox/componentbox/master/desktop/src/jvmMain/resources/tag.jpeg"
private const val FAKE_CONTENT_DESCRIPTION = "tag"
private const val FAKE_NAME = "Tag Ramotar"
private const val FAKE_EMAIL = "tag@dropbox.com"