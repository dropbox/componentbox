package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@Serializable
enum class Alignment: Parcelable {
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
enum class Arrangement: Parcelable {
    Start,
    End,
    Top,
    Bottom,
    Center,
    SpaceEvenly,
    SpaceBetween,
    SpaceAround
}