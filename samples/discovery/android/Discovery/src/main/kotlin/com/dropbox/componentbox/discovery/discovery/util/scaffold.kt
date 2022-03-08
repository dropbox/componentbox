package com.dropbox.componentbox.discovery.discovery.util

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.discovery.discovery.scaffold.ScaffoldCallback

fun ScaffoldCallback.setUpScreen(title: String, topBarActions: List<@Composable () -> Unit>) {
    setTitle(title)
    setTopBarActions(topBarActions)
}