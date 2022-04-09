package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.JsonTransformingSerializer
import kotlinx.serialization.json.jsonPrimitive

@Serializable
data class Color(
    val title: String,
    val light: Long,
    val dark: Long
): Parcelable

interface Colors {
    val primary: Color
    val primaryVariant: Color
    val secondary: Color
    val secondaryVariant: Color
    val background: Color
    val surface: Color
    val error: Color
    val onPrimary: Color
    val onSecondary: Color
    val onBackground: Color
    val onSurface: Color
    val onError: Color
    fun list(): MutableList<Color>
}


object ColorSerializer :JsonTransformingSerializer<Long>(Long.serializer()) {
    override fun transformDeserialize(element: JsonElement): JsonElement {
        return JsonPrimitive(element.jsonPrimitive.content.toLong())
    }
}