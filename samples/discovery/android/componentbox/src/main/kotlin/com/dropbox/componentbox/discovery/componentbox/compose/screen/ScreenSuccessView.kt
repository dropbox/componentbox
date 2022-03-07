package com.dropbox.componentbox.discovery.componentbox.compose.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dropbox.componentbox.discovery.zipline.ComponentBoxScreenViewModel
import com.dropbox.componentbox.horizontal
import com.dropbox.componentbox.samples.discovery.Inflate
import com.dropbox.componentbox.vertical

@Composable
fun ScreenSuccessView(viewModel: ComponentBoxScreenViewModel) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = viewModel.root?.verticalArrangement.vertical(),
        horizontalAlignment = viewModel.root?.horizontalAlignment.horizontal()
    ) {
        viewModel.root?.components?.forEach { component ->
            component.Inflate()
        }
    }
}
