package com.dropbox.componentbox.store.state

data class AppState(
    val componentState: ComponentState,
    val screenState: ScreenState,
    val themeState: ThemeState
)