package com.dropbox.componentbox.models

actual interface Image: DrawableRes

data class RealImage(
    override val name: String,
    override val light: MultiplatformRes,
    override val dark: MultiplatformRes
) : Image