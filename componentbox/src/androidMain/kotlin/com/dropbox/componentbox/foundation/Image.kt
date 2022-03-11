package com.dropbox.componentbox.foundation

actual interface Image : DrawableRes

data class RealImage(
    override val name: String,
    override val resId: Int
) : Image