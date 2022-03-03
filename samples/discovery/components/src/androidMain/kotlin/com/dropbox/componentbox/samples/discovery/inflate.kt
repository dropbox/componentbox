package com.dropbox.componentbox.samples.discovery

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.models.Component
import com.dropbox.componentbox.samples.discovery.box.Inflate
import com.dropbox.componentbox.samples.discovery.button.Inflate
import com.dropbox.componentbox.samples.discovery.column.Inflate
import com.dropbox.componentbox.samples.discovery.drawable.Inflate
import com.dropbox.componentbox.samples.discovery.row.Inflate
import com.dropbox.componentbox.samples.discovery.switch.Inflate
import com.dropbox.componentbox.samples.discovery.text.Inflate
import com.dropbox.componentbox.samples.discovery.vector.Inflate

@Composable
actual fun Component.Inflate() {
    when (this) {
        is Component.Box -> this.Inflate()
        is Component.Button -> this.Inflate()
        is Component.Column -> this.Inflate()
        is Component.Drawable -> this.Inflate()
        is Component.Row -> this.Inflate()
        is Component.Switch -> this.Inflate()
        is Component.Text -> this.Inflate()
        is Component.Vector -> this.Inflate()
    }
}