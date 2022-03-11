package com.dropbox.componentbox.foundation

expect interface Image

interface Images {
    fun list(): MutableList<Image>
}

enum class ImageType {
    Light,
    Dark
}