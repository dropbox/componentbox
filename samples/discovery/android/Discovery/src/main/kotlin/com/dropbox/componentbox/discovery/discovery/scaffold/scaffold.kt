package com.dropbox.componentbox.discovery.discovery.scaffold

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun Scaffold() {
    val presenter: ScaffoldPresenter = hiltViewModel()

    val tabs = presenter.inflater.bottomTabs()
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(tabs[3]) }
    val title = remember { mutableStateOf("") }
    val topBarActions = remember { mutableStateListOf<@Composable () -> Unit>() }

    val callback = object : ScaffoldCallback {
        override fun setTitle(value: String) {
            title.value = value
        }

        override fun setTopBarActions(value: List<@Composable () -> Unit>) {
            topBarActions.clear()
            topBarActions.addAll(value)
        }
    }

    Scaffold(
        topBar = topBar(title.value, topBarActions),
        bottomBar = bottomBar(tabs, selectedTab) { setSelectedTab(it) }
    ) { innerPadding ->
        Screen(innerPadding, selectedTab, callback)
    }
}