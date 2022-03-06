package com.dropbox.componentbox.discovery.discovery.plans.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dropbox.componentbox.discovery.componentbox.compose.ComponentBoxView
import com.dropbox.componentbox.models.ComponentBox
import com.dropbox.componentbox.discovery.discovery.scaffold.ScaffoldCallback

@Composable
fun PlansScreen(callback: ScaffoldCallback) {
    val id = "1"
    ComponentBoxView<ComponentBox.Screen>(
        id = id,
        CustomLoading = { CustomLoading() },
    )
}

@Composable
private fun CustomLoading() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "Loading")
    }
}