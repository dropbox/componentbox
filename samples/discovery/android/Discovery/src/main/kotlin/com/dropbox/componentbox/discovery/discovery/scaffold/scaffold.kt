package com.dropbox.componentbox.discovery.discovery.scaffold

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.dropbox.componentbox.Inflater

@Composable
fun Scaffold(inflater: Inflater) {
    val tabs = inflater.bottomTabs()

    val (selectedTab, setSelectedTab) = remember { mutableStateOf(tabs[3]) }
    val title = remember { mutableStateOf("") }

    val callback = object : ScaffoldCallback {
        override fun setTitle(value: String) {
            title.value = value
        }
    }

    Scaffold(
        topBar = topBar(title.value),
        bottomBar = bottomBar(tabs, selectedTab) { tab -> setSelectedTab(tab) }
    ) { innerPadding ->
        Screen(innerPadding, selectedTab, callback)
    }
}