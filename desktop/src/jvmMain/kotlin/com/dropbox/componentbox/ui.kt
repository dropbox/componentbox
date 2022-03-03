package com.dropbox.componentbox

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dropbox.componentbox.data.entities.Context
import com.dropbox.componentbox.ui.surfaces.explorer.explorer
import com.dropbox.componentbox.ui.surfaces.inspector.inspector
import com.dropbox.componentbox.ui.surfaces.simulator.simulator
import com.dropbox.componentbox.ui.surfaces.toolbar.Toolbar

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