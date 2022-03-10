package com.dropbox.componentbox.discovery.discovery.scaffold

import androidx.compose.runtime.Composable

interface ScaffoldCallback {
    fun setTitle(value: String)
    fun setTopBarActions(value: List<@Composable () -> Unit>)
}