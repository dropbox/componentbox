package com.dropbox.componentbox.discovery.discovery.common.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.Campaign
import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.CampaignAction
import com.dropbox.componentbox.discovery.theme.R

@Composable
fun Campaign.Inflate(onDismiss: () -> Unit) = when (this) {
    is Campaign.Banner.ComponentBoxBanner -> TODO()
    is Campaign.Banner.PromptBanner -> Inflate(onDismiss)
    is Campaign.Modal.ComponentBox -> TODO()
    is Campaign.Modal.PromptModal -> Inflate()
    is Campaign.UpgradeScreen.ComponentBoxUpgradeScreen -> TODO()
    is Campaign.UpgradeScreen.PromptUpgradeScreen -> Inflate()
}

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

fun CampaignAction.run(): () -> Unit = when (this) {
    CampaignAction.OpenUpsellScreen -> {
        {}
    }
    CampaignAction.OpenFeatureDiscoveryScreen -> {
        {}
    }
}

@Composable
fun Campaign.Modal.PromptModal.Inflate() {
    Dialog(onDismissRequest = { /*TODO*/ }) {

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
