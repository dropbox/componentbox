package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@Serializable
data class Modifier(
    var fillMaxSize: Boolean? = null,
    var fillMaxHeight: Boolean? = null,
    var fillMaxWidth: Boolean? = null,
    var height: Int? = null,
    var width: Int? = null,
    var padding: Padding? = null,
    var margin: Margin? = null,
    var background: String? = null,
    var weight: Float? = null
)

@Serializable
data class Margin(
    val start: Int? = null,
    val top: Int? = null,
    val end: Int? = null,
    val bottom: Int? = null
)

@Serializable
data class Padding(
    val start: Int? = null,
    val top: Int? = null,
    val end: Int? = null,
    val bottom: Int? = null
)

@Serializable
enum class ContentScale {
    Crop,
    Fit,
    FillHeight,
    FillWidth,Inside,
    None,
    FillBounds
}