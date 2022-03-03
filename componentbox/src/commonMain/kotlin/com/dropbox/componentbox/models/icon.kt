package com.dropbox.componentbox.models

data class Icon(
    val line: VectorRes,
    val fill: VectorRes? = null,
    val pictogram: VectorRes? = null,
    val spot: VectorRes? = null
)

expect interface Icons {
    fun list(): MutableList<Icon>
}

enum class IconType {
    Line,
    Fill,
    Pictogram,
    Spot
}