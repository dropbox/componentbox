package com.dropbox.componentbox.samples.discovery.vector

import com.dropbox.componentbox.discovery.theme.R
import com.dropbox.componentbox.models.Icon
import com.dropbox.componentbox.models.Icons
import com.dropbox.componentbox.models.RealVectorRes

actual class DiscoveryIcons : Icons {
    actual val checkmarkCircle = Icon(
        line = RealVectorRes("CheckmarkCircle.Line", R.drawable.ic_dig_checkmark_circle_line),
        fill = RealVectorRes("CheckmarkCircle.Fill", R.drawable.ic_dig_checkmark_circle_fill),
        pictogram = null,
        spot = null,
    )

    actual val fail = Icon(
        line = RealVectorRes("Fail.Line", R.drawable.ic_dig_fail_line),
        fill = RealVectorRes("Fail.Fill", R.drawable.ic_dig_fail_fill),
        pictogram = null,
        spot = null,
    )

    actual val twinkle2 = Icon(
        line = RealVectorRes("Twinkle2.Line", R.drawable.ic_dig_twinkle_2_line),
        fill = RealVectorRes("Twinkle2.Fill", R.drawable.ic_dig_twinkle_2_fill),
        pictogram = null,
        spot = null,
    )

    override fun list() = mutableListOf(
        checkmarkCircle,
        fail,
        twinkle2
    )
}