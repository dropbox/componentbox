package com.dropbox.desktop.componentbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dropbox.desktop.componentbox.data.entities.Context
import com.dropbox.componentbox.foundation.Inflater
import com.dropbox.componentbox.foundation.Themer
import com.dropbox.desktop.componentbox.ui.surfaces.explorer.explorer
import com.dropbox.desktop.componentbox.ui.surfaces.inspector.inspector
import com.dropbox.desktop.componentbox.ui.surfaces.simulator.simulator
import com.dropbox.desktop.componentbox.ui.surfaces.toolbar.Toolbar

@Composable
fun ui(context: Context, inflater: Inflater, themer: Themer) {
    Column(modifier = Modifier.background(color = MaterialTheme.colors.background).fillMaxSize()) {
        Toolbar()

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            explorer()
            simulator(inflater)
            inspector(context, themer)
        }
    }
}