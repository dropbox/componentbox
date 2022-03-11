package com.dropbox.componentbox.foundation

expect interface TextStyle

interface Typography {
    val h1: TextStyle
    val h2: TextStyle
    val h3: TextStyle
    val h4: TextStyle
    val h5: TextStyle
    val h6: TextStyle
    val body1: TextStyle
    val body2: TextStyle
    val button: TextStyle
    val caption: TextStyle
    fun list(): MutableList<TextStyle>
}