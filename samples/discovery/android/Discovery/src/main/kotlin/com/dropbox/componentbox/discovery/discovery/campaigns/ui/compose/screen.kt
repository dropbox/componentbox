package com.dropbox.componentbox.discovery.discovery.campaigns.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.Campaign

// TODO(mramotar)
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
            Text(text = title, style = MaterialTheme.typography.h6)
            Text(text = text, style = MaterialTheme.typography.body2)
            Text(text = subtext, style = MaterialTheme.typography.body2)
        }
    }
}