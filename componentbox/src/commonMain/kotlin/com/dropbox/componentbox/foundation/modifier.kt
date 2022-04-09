package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Modifier(
    var fillMaxSize: Boolean? = null,
    var fillMaxHeight: Boolean? = null,
    var fillMaxWidth: Boolean? = null,
    var height: Int? = null,
    var width: Int? = null,
    var padding: Padding? = null,
    var margin: Margin? = null,
    var background: Color? = null,
    var weight: Float? = null
): Parcelable

@Parcelize
@Serializable
data class Margin(
    val start: Int? = null,
    val top: Int? = null,
    val end: Int? = null,
    val bottom: Int? = null
): Parcelable

@Parcelize
@Serializable
data class Padding(
    val start: Int? = null,
    val top: Int? = null,
    val end: Int? = null,
    val bottom: Int? = null
): Parcelable

@Parcelize
@Serializable
enum class ContentScale: Parcelable {
    Crop,
    Fit,
    FillHeight,
    FillWidth,Inside,
    None,
    FillBounds
}