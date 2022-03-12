package com.dropbox.componentbox.discovery.discovery.plans.ui

import androidx.compose.runtime.Composable
import com.airbnb.mvrx.compose.mavericksViewModel
import com.dropbox.componentbox.compose.ComponentBoxView
import com.dropbox.componentbox.discovery.discovery.plans.presentation.PlansScreenPresenter
import com.dropbox.componentbox.discovery.discovery.scaffold.ScaffoldCallback
import com.dropbox.componentbox.discovery.discovery.scoping.appScope

@Composable
fun PlansScreen(callback: ScaffoldCallback) {
    val title = "Upgrade to Dropbox Plus"
    val topBarActions = listOf<@Composable () -> Unit>()
    val presenter: PlansScreenPresenter = mavericksViewModel()

    callback.setTitle(title)
    callback.setTopBarActions(topBarActions)

    ComponentBoxView(
        presenter = presenter.bridge(),
        context = appScope().context,
        Loading = { },
        Fallback = { }
    )
}