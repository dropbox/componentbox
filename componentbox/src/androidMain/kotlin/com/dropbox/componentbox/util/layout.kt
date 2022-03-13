package com.dropbox.componentbox.util

import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Arrangement
import androidx.compose.foundation.layout.Arrangement as RealArrangement
import androidx.compose.ui.Alignment as RealAlignment

// This module targets JS
// Until material and foundation are supported on JS
// Changes to this file should be duplicated in jvmMain
// TODO(https://github.com/dropbox/componentbox/issues/25)

fun Alignment?.horizontal(): RealAlignment.Horizontal = when (this) {
    Alignment.Start -> RealAlignment.Start
    Alignment.CenterHorizontally -> RealAlignment.CenterHorizontally
    Alignment.End -> RealAlignment.End
    else -> RealAlignment.Start
}

fun Alignment?.vertical(): RealAlignment.Vertical = when (this) {
    Alignment.Top -> RealAlignment.Top
    Alignment.CenterVertically -> RealAlignment.CenterVertically
    Alignment.Bottom -> RealAlignment.Bottom
    else -> RealAlignment.Top
}

fun Alignment?.alignment(): RealAlignment = when (this) {
    Alignment.TopStart -> RealAlignment.TopStart
    Alignment.TopCenter -> RealAlignment.TopCenter
    Alignment.TopEnd -> RealAlignment.TopEnd
    Alignment.CenterStart -> RealAlignment.CenterStart
    Alignment.Center -> RealAlignment.Center
    Alignment.CenterEnd -> RealAlignment.CenterEnd
    Alignment.BottomStart -> RealAlignment.BottomStart
    Alignment.BottomCenter -> RealAlignment.BottomCenter
    Alignment.BottomEnd -> RealAlignment.BottomEnd
    else -> RealAlignment.TopStart
}

fun Arrangement?.vertical(): RealArrangement.Vertical = when (this) {
    Arrangement.Top -> RealArrangement.Top
    Arrangement.Bottom -> RealArrangement.Bottom
    Arrangement.Center -> RealArrangement.Center
    Arrangement.SpaceEvenly -> RealArrangement.SpaceEvenly
    Arrangement.SpaceBetween -> RealArrangement.SpaceBetween
    Arrangement.SpaceAround -> RealArrangement.SpaceAround
    else -> androidx.compose.foundation.layout.Arrangement.Top
}

fun Arrangement?.horizontal(): RealArrangement.Horizontal = when (this) {
    Arrangement.Start -> RealArrangement.Start
    Arrangement.End -> RealArrangement.End
    Arrangement.Center -> RealArrangement.Center
    Arrangement.SpaceEvenly -> RealArrangement.SpaceEvenly
    Arrangement.SpaceBetween -> RealArrangement.SpaceBetween
    Arrangement.SpaceAround -> RealArrangement.SpaceAround
    else -> androidx.compose.foundation.layout.Arrangement.Start
}