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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.airbnb.mvrx.compose.mavericksViewModel
import com.dropbox.componentbox.discovery.componentbox.compose.ComponentBoxView
import com.dropbox.componentbox.discovery.discovery.account.presentation.DiscoveryPresenter
import com.dropbox.componentbox.discovery.discovery.campaigns.data.Campaign
import com.dropbox.componentbox.discovery.discovery.campaigns.data.componentBoxId
import com.dropbox.componentbox.discovery.discovery.scaffold.ScaffoldCallback
import com.dropbox.componentbox.discovery.discovery.util.setUpScreen
import com.dropbox.componentbox.discovery.theme.R
import com.dropbox.componentbox.models.ComponentBox
import com.dropbox.componentbox.samples.discovery.color.standardBackgroundElevated
import com.dropbox.componentbox.samples.discovery.color.standardText


private const val TITLE = "Account"

@Composable
fun AccountScreen(scaffoldCallback: ScaffoldCallback) {

    scaffoldCallback.setUpScreen(TITLE, listOf {
        GearIcon()
    })

    val presenter: DiscoveryPresenter = mavericksViewModel()

    val bestBanner = remember { mutableStateOf(presenter.getBestCampaign<Campaign.Banner>()) }
    val bestModal = remember { mutableStateOf(presenter.getBestCampaign<Campaign.Modal>()) }

    Box {
        AccountScreenLazyColumn {
            ComponentBoxView<ComponentBox.Banner>(id = bestBanner.value.componentBoxId())
        }

        ComponentBoxView<ComponentBox.Modal>(id = bestModal.value.componentBoxId())
    }
}

@Composable
fun AccountScreenLazyColumn(Banner: (@Composable () -> Unit) = {}) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.standardBackgroundElevated),
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        items(1) {
            Banner()
            AccountInfo()
            AccountDetails()
            AccountFeatures()
            AccountSettings()
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