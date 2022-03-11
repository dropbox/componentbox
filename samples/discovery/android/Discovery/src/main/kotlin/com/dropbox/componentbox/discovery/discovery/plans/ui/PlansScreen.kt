package com.dropbox.componentbox.discovery.discovery.plans.ui

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.compose.ComponentBoxView
import com.dropbox.componentbox.discovery.discovery.plans.presentation.PlansScreenPresenter
import com.dropbox.componentbox.discovery.discovery.scaffold.ScaffoldCallback
import com.dropbox.componentbox.discovery.discovery.scoping.appScope
import com.dropbox.componentbox.zipline.ComponentBoxZipline

@Composable
fun PlansScreen(callback: ScaffoldCallback) {
    val title = "Upgrade to Dropbox Plus"
    val topBarActions = listOf<@Composable () -> Unit>()
    val ziplineUrl = "https://api.componentbox.io/zipline/1.js"
    val componentBoxUrl = "https://api.componentbox.io/screens/1.json"
    val zipline = ComponentBoxZipline(ziplineUrl)
    val presenter = PlansScreenPresenter(zipline)

    callback.setTitle(title)
    callback.setTopBarActions(topBarActions)

    ComponentBoxView(
        componentBoxUrl = componentBoxUrl,
        presenter = presenter,
        context = appScope().context,
        Loading = { TODO() },
        Fallback = { TODO() }
    )
}