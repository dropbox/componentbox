package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@Parcelize
@Serializable
enum class ComponentType: Parcelable {
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