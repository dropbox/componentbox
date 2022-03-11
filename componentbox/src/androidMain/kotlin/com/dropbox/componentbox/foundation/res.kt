package com.dropbox.componentbox.foundation

actual interface MultiplatformRes {
    val name: String
    val resId: Int
}

actual interface DrawableRes : MultiplatformRes

data class RealMultiplatformRes(
    override val name: String,
    override val resId: Int
) : MultiplatformRes

data class RealDrawableRes(
    override val name: String,
    override val resId: Int
) : DrawableRes

actual interface StringRes {
    val resId: Int
}

data class RealStringRes(
    override val resId: Int
) : StringRes

actual interface VectorRes : MultiplatformRes

data class RealVectorRes(
    override val name: String,
    override val resId: Int
) : VectorRes