package com.dropbox.componentbox.models

actual interface Icons {
    actual fun list(): MutableList<Icon>
    fun resPaths(): MutableList<MultiplatformRes>
}