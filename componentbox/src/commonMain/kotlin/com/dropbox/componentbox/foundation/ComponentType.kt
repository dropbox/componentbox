package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@Serializable
enum class ComponentType {
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
}