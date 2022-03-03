package com.dropbox.componentbox.samples.discovery.switch

import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.build
import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.samples.discovery.action

@Composable
fun Component.Switch.Inflate() {
    Switch(
        checked = this.isChecked == true,
        onCheckedChange = { this.action.action().action().action() },
        modifier = this.modifier.build()
    )
}
