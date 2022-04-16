package com.dropbox.desktop.componentbox.store.state

import com.dropbox.componentbox.foundation.Color

data class ThemeState(
    var isNightMode: Boolean = true,
    var colors: MutableList<Color> = mutableListOf(),
    var background: Color = Color("Background", 0xFFFFFFFF, 0xFF161313)
)
