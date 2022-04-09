package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@IsPassable
@Serializable
enum class ComponentType: Passable {
    Box,
    Button,
    Column,
    Drawable,
    LazyColumn,
    LazyRow,
    Row,
    Switch,
    Table,
    Text,
    Vector,
    Surface
}