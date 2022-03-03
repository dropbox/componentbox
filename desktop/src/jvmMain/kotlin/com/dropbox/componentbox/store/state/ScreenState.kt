package com.dropbox.componentbox.store.state

import com.dropbox.componentbox.models.Alignment
import com.dropbox.componentbox.models.Arrangement

data class ScreenState(
    val id: String,
    var title: String? = null,
    var verticalArrangement: Arrangement = Arrangement.Top,
    var horizontalAlignment: Alignment = Alignment.Start,
    var showBottomTabs: Boolean = false,
    var isNightMode: Boolean = true,
    var isPreview: Boolean = false
)
