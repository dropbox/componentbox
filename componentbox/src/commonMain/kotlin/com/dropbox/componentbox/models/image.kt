package com.dropbox.componentbox.models

expect interface Image

interface Images {
    fun list(): MutableList<Image>
}

enum class ImageType {
    Light,
    Dark
}