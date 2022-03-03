package com.dropbox.componentbox.ui.surfaces.simulator

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.Inflater
import com.dropbox.componentbox.ui.surfaces.simulator.devices.pixel4

@Composable
fun simulator(inflater: Inflater) {
    pixel4 {
        screen(inflater)
    }
}