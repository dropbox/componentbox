package com.dropbox.componentbox.discovery.discovery.home.ui

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.compose.ComponentBoxLoadingView
import com.dropbox.componentbox.discovery.discovery.scaffold.ScaffoldCallback

@Composable
fun HomeScreen(callback: ScaffoldCallback){
    callback.setTitle("Home")

    ComponentBoxLoadingView()
}