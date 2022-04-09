package com.dropbox.componentbox.foundation

import kotlinx.serialization.Serializable

@Serializable
sealed class Component: Parcelable {

    @Parcelize
    @Serializable
    data class Box(
        val id: String,
        var components: MutableList<Component>? = null,
        var modifier: Modifier? = null,
        var horizontalArrangement: Arrangement? = null,
        var verticalAlignment: Alignment? = null,
        var action: String? = null,
    ) : Component(), Parcelable

    @Parcelize
    @Serializable
    data class Row(
        val id: String,
        var components: MutableList<Component>? = null,
        var modifier: Modifier? = null,
        var horizontalArrangement: Arrangement? = null,
        var verticalAlignment: Alignment? = null,
        var action: String? = null,
        var isLazy: Boolean? = null
    ) : Component(), Parcelable

    @Parcelize
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
    ) : Component(), Parcelable

    @Parcelize
    @Serializable
    data class Text(
        val id: String,
        var modifier: Modifier? = null,
        var text: String? = null,
        var color: Color? = null,
        var textStyle: String? = null
    ) : Component(), Parcelable

    @Parcelize
    @Serializable
    data class Button(
        val id: String,
        var components: MutableList<Component>? = null,
        var modifier: Modifier? = null,
        var isEnabled: Boolean? = null,
        var action: String? = null,
        var variant: String? = null,
    ) : Component(), Parcelable

    @Parcelize
    @Serializable
    data class Switch(
        val id: String,
        var isChecked: Boolean? = null,
        var modifier: Modifier? = null,
        var action: String? = null,
    ) : Component(), Parcelable

    @Parcelize
    @Serializable
    data class Drawable(
        val id: String,
        var name: String? = null,
        var url: String? = null,
        val contentDescription: String? = null,
        var modifier: Modifier? = null,
        var alignment: Alignment? = null,
        var contentScale: ContentScale? = null
    ) : Component(), Parcelable

    @Parcelize
    @Serializable
    data class Vector(
        val id: String,
        var name: String? = null,
        var modifier: Modifier? = null,
        var alignment: Alignment? = null,
        var contentScale: ContentScale? = null,
        var color: Color? = null
    ) : Component(), Parcelable

    @Parcelize
    @Serializable
    data class Surface(
        val id: String,
        var modifier: Modifier? = null,
        var shape: Shape? = null,
        var color: Color? = null,
        var contentColor: Color? = null,
        var borderStroke: BorderStroke? = null,
        var elevation: Int? = null,
        var components: MutableList<Component>? = null,
    ) : Component(), Parcelable
}

