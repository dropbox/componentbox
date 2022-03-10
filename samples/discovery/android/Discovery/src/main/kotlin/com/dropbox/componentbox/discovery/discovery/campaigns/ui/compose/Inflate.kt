package com.dropbox.componentbox.discovery.discovery.campaigns.ui.compose

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.Campaign

@Composable
fun Campaign.Inflate(onDismiss: () -> Unit) = when (this) {
    is Campaign.Banner.ComponentBoxBanner -> TODO()
    is Campaign.Banner.PromptBanner -> Inflate(onDismiss)
    is Campaign.Modal.ComponentBoxModal -> TODO()
    is Campaign.Modal.PromptModal -> Inflate(onDismiss)
    is Campaign.UpgradeScreen.ComponentBoxUpgradeScreen -> TODO()
    is Campaign.UpgradeScreen.PromptUpgradeScreen -> Inflate()
    is Campaign.Banner.PromptBigBanner -> Inflate(onDismiss)
    is Campaign.Banner.ComponentBoxBigBanner -> TODO()
}