package com.dropbox.componentbox.models

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