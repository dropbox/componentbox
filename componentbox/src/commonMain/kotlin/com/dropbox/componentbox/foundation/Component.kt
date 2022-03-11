package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@Serializable
sealed class Component {

    @Serializable
    data class Box(
        val id: String,
        var components: MutableList<Component>? = null,
        var modifier: Modifier? = null,
        var horizontalArrangement: Arrangement? = null,
        var verticalAlignment: Alignment? = null,
        var action: String? = null,
    ) : Component()

    @Serializable
    data class Row(
        val id: String,
        var components: MutableList<Component>? = null,
        var modifier: Modifier? = null,
        var horizontalArrangement: Arrangement? = null,
        var verticalAlignment: Alignment? = null,
        var action: String? = null,
        var isLazy: Boolean? = null
    ) : Component()

    @Serializable
    data class Column(
        val id: String,
        var components: MutableList<Component>? = null,
        var modifier: Modifier? = null,
        var verticalArrangement: Arrangement? = null,
        var horizontalAlignment: Alignment? = null,
        var isLazy: Boolean? = null,
        var isTable: Boolean? = null,
        var action: String? = null
    ) : Component()

    @Serializable
    data class Text(
        val id: String,
        var modifier: Modifier? = null,
        var text: String? = null,
        var color: String? = null,
        var textStyle: String? = null
    ) : Component()

    @Serializable
    data class Button(
        val id: String,
        var components: MutableList<Component>? = null,
        var modifier: Modifier? = null,
        var isEnabled: Boolean? = null,
        var action: String? = null,
        var variant: String? = null,
    ) : Component()

    @Serializable
    data class Switch(
        val id: String,
        var isChecked: Boolean? = null,
        var modifier: Modifier? = null,
        var action: String? = null,
    ) : Component()

    @Serializable
    data class Drawable(
        val id: String,
        var name: String? = null,
        var url: String? = null,
        val contentDescription: String? = null,
        var modifier: Modifier? = null,
        var alignment: Alignment? = null,
        var contentScale: ContentScale? = null
    ) : Component()

    @Serializable
    data class Vector(
        val id: String,
        var name: String? = null,
        var modifier: Modifier? = null,
        var alignment: Alignment? = null,
        var contentScale: ContentScale? = null,
        var color: String? = null
    ) : Component()
}

