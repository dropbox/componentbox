package com.dropbox.componentbox.discovery.discovery.photos.ui

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.compose.ComponentBoxLoadingView
import com.dropbox.componentbox.discovery.discovery.scaffold.ScaffoldCallback

@Composable
fun PhotosScreen(callback: ScaffoldCallback) {

    callback.setTitle("Photos")

    ComponentBoxLoadingView()
}