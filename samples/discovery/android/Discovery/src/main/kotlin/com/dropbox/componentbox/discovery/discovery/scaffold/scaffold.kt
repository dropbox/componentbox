package com.dropbox.componentbox.discovery.discovery.scaffold

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun Scaffold() {
    val presenter: ScaffoldPresenter = hiltViewModel()
    presenter.load()

    val callback = object : ScaffoldCallback {
        override fun setTitle(value: String) {
            presenter.title = value
        }

        override fun setTopBarActions(value: List<@Composable () -> Unit>) {
            presenter.topBarActions.clear()
            presenter.topBarActions.addAll(value)
        }
    }

    if (presenter.tabs.isNotEmpty() && presenter.selectedTab != null) {
        Scaffold(
            topBar = topBar(presenter.title, presenter.topBarActions),
            bottomBar = bottomBar(presenter.tabs, presenter.selectedTab!!) { presenter.selectedTab = it }
        ) { innerPadding ->
            Screen(innerPadding, presenter.selectedTab!!, callback)
        }
    }
}