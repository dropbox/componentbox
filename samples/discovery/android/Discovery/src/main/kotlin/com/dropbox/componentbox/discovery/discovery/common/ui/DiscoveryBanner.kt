package com.dropbox.componentbox.discovery.discovery.common.ui

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
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.dropbox.componentbox.discovery.discovery.account.ui.AccountBanner
import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.Campaign
import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.CampaignAction
import com.dropbox.componentbox.discovery.theme.R
import com.dropbox.componentbox.samples.discovery.color.disabledBackground

@Composable
fun Campaign.Inflate(onDismiss: () -> Unit) = when (this) {
    is Campaign.Banner.ComponentBoxBanner -> TODO()
    is Campaign.Banner.PromptBanner -> Inflate(onDismiss)
    is Campaign.Modal.ComponentBox -> TODO()
    is Campaign.Modal.PromptModal -> Inflate(onDismiss)
    is Campaign.UpgradeScreen.ComponentBoxUpgradeScreen -> TODO()
    is Campaign.UpgradeScreen.PromptUpgradeScreen -> Inflate()
}

@Composable
fun Campaign.Banner.PromptBanner.Inflate(onDismiss: () -> Unit) {
    when (id) {
        "3" -> AccountBanner(onDismiss)
        else -> Standard(onDismiss)
    }
}

@Composable
fun Campaign.Banner.PromptBanner.Standard(onDismiss: () -> Unit) {
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

fun CampaignAction.run(): () -> Unit = when (this) {
    CampaignAction.OpenUpsellScreen -> {
        {}
    }
    CampaignAction.OpenFeatureDiscoveryScreen -> {
        {}
    }
}

@Composable
fun Campaign.Modal.PromptModal.Inflate(onDismiss: () -> Unit) {
    when (id) {
        "2" -> New(onDismiss)
        else -> Standard(onDismiss)
    }
}

@Composable
fun Campaign.Modal.PromptModal.New(onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            elevation = 2.dp,
        ) {

            Box {

                Image(
                    painter = painterResource(R.drawable.background),
                    contentDescription = null,

                    )

                Column(
                    modifier = Modifier.padding(top = 36.dp, start = 24.dp, end = 24.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {

                    Icon(
                        painter = painterResource(id = R.drawable.dig_dropbox_logo),
                        contentDescription = null,
                        tint = Color(0xffD5C7FB)
                    )

                    Text(
                        text = "Best gift ever",
                        style = MaterialTheme.typography.h1.copy(fontSize = 56.sp),
                        color = Color(0xffADEEE0),
                    )

                    Text(
                        text = "Give your family Plus for 3 months free.",
                        style = MaterialTheme.typography.h5,
                        color = Color(0xffD5C7FB)
                    )

                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xffEA516C)),
                        elevation = ButtonDefaults.elevation(0.dp),
                        modifier = Modifier.padding(top = 8.dp),
                        shape = RectangleShape
                    ) {
                        Text(
                            text = "Add my family",
                            style = MaterialTheme.typography.h6,
                            color = Color(0xffD5C7FB)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Campaign.Modal.PromptModal.Standard(onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            elevation = 2.dp,
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier.padding(vertical = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier
                        .height(220.dp),
                    contentScale = ContentScale.FillHeight,
                )

                Column(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(text = text, style = MaterialTheme.typography.h5)
                    Text(text = subtext, style = MaterialTheme.typography.body1)
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RectangleShape,
                        elevation = ButtonDefaults.elevation(0.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = confirmText,
                            style = MaterialTheme.typography.button,
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                    Button(
                        onClick = onDismiss,
                        shape = RectangleShape,
                        elevation = ButtonDefaults.elevation(0.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.disabledBackground),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = dismissText,
                            style = MaterialTheme.typography.button,
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Campaign.UpgradeScreen.PromptUpgradeScreen.Inflate() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column() {
            Text(text = "Turn on camera uploads", style = MaterialTheme.typography.h6)
            Text(text = "Keep all your photos safe and sound", style = MaterialTheme.typography.body2)
        }
    }
}
