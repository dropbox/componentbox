package com.dropbox.componentbox

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.models.Margin
import com.dropbox.componentbox.models.Modifier
import com.dropbox.componentbox.models.Padding
import androidx.compose.ui.Modifier as RealModifier

fun Modifier?.build(customModifiers: List<RealModifier>? = null): RealModifier {
    var modifier: RealModifier = RealModifier

    if (this == null) return modifier

    modifier = modifier.then(margin(this.margin))
    modifier = modifier.then(width(this))
    modifier = modifier.then(height(this))

    customModifiers?.forEach { customModifier ->
        modifier = modifier.then(customModifier)
    }

    modifier = modifier.then(padding(this.padding))

    return modifier
}

private fun margin(margin: Margin?): RealModifier {
    if (margin == null) return RealModifier

    return padding(
        Padding(
            start = margin.start,
            end = margin.end,
            top = margin.top,
            bottom = margin.bottom
        )
    )
}

private fun padding(padding: Padding?): RealModifier {
    val start = padding?.start ?: 0
    val end = padding?.end ?: 0
    val top = padding?.top ?: 0
    val bottom = padding?.bottom ?: 0

    return RealModifier.padding(
        start = start.dp,
        top = top.dp,
        end = end.dp,
        bottom = bottom.dp
    )
}

private fun width(modifier: Modifier): RealModifier {
    return if (modifier.fillMaxWidth == true) {
        RealModifier.fillMaxWidth()
    } else if (modifier.width != null) {
        RealModifier.width(modifier.width!!.dp)
    } else {
        RealModifier
    }
}

private fun height(modifier: Modifier): RealModifier {
    return if (modifier.fillMaxHeight == true) {
        RealModifier.fillMaxHeight()
    } else if (modifier.height != null) {
        RealModifier.height(modifier.height!!.dp)
    } else {
        RealModifier
    }
}