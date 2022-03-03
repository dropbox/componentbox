package com.dropbox.componentbox.store.actions

import com.dropbox.componentbox.models.Color

sealed class ThemeAction {
    object ToggleNightMode : ThemeAction()
    data class SetColors(
        val colors: MutableList<Color>
    ) : ThemeAction()

    data class SetBackground(
        val color: Color
    ): ThemeAction()
}