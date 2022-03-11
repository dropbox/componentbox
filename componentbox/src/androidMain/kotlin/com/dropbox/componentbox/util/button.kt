package com.dropbox.componentbox.util

import com.dropbox.componentbox.foundation.ButtonVariant

fun String?.buttonVariant(): ButtonVariant {
    return when (this) {
        ButtonVariant.Contained.name -> ButtonVariant.Contained
        ButtonVariant.Text.name -> ButtonVariant.Text
        ButtonVariant.Outlined.name -> ButtonVariant.Outlined
        ButtonVariant.Icon.name -> ButtonVariant.Icon
        else -> ButtonVariant.Contained
    }
}