package com.dropbox.desktop.componentbox.ui.components

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource

@Composable
fun searchIcon() {
    Icon(painter = painterResource(SEARCH_LINE_RESOURCE_PATH), contentDescription = null)
}

const val SEARCH_LINE_RESOURCE_PATH = "drawable/ic_dig_search_line.xml"