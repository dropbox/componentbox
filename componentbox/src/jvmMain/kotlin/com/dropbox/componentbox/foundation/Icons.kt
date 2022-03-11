package com.dropbox.componentbox.foundation

actual interface Icons {
    actual fun list(): MutableList<Icon>
    fun resPaths(): MutableList<MultiplatformRes>
}