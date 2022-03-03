package com.dropbox.componentbox.models

import kotlinx.serialization.Serializable

@Serializable
enum class Alignment {
    TopStart,
    TopCenter,
    TopEnd,
    CenterStart,
    Center,
    CenterEnd,
    BottomStart,
    BottomCenter,
    BottomEnd,
    Top,
    CenterVertically,
    Bottom,
    Start,
    CenterHorizontally,
    End
}

@Serializable
enum class Arrangement {
    Start,
    End,
    Top,
    Bottom,
    Center,
    SpaceEvenly,
    SpaceBetween,
    SpaceAround
}