package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@IsPassable
@Serializable
enum class Alignment: Passable {
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

@IsPassable
@Serializable
enum class Arrangement: Passable {
    Start,
    End,
    Top,
    Bottom,
    Center,
    SpaceEvenly,
    SpaceBetween,
    SpaceAround
}