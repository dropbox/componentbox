package com.dropbox.desktop.componentbox.ui.surfaces.simulator

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Inflater
import com.dropbox.desktop.componentbox.ui.surfaces.simulator.devices.pixel4

@Composable
fun simulator(inflater: Inflater) {
    pixel4 {
        screen(inflater)
    }
}