package com.dropbox.componentbox.models

actual interface MultiplatformRes {
    val name: String
    val resPath: String
}

data class RealMultiplatformRes(
    override val name: String,
    override val resPath: String
) : MultiplatformRes

actual interface DrawableRes {
    val name: String
    val light: MultiplatformRes
    val dark: MultiplatformRes
}

data class RealDrawableRes(
    override val name: String,
    override val light: MultiplatformRes,
    override val dark: MultiplatformRes
) : DrawableRes

actual interface StringRes {
    val value: String
}

data class RealStringRes(
    override val value: String
) : StringRes

actual interface VectorRes : MultiplatformRes

data class RealVectorRes(
    override val name: String,
    override val resPath: String
) : VectorRes