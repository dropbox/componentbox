package com.dropbox.componentbox.samples.discovery.switch

import androidx.compose.material.Switch
import androidx.compose.runtime.Composable
import com.dropbox.componentbox.util.build
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.samples.discovery.action

@Composable
fun Component.Switch.Inflate() {
    Switch(
        checked = this.isChecked == true,
        onCheckedChange = { this.action.action().action().action() },
        modifier = this.modifier.build()
    )
}
