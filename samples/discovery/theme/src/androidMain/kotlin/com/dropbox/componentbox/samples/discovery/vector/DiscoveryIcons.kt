package com.dropbox.componentbox.samples.discovery.vector

import com.dropbox.componentbox.discovery.theme.R
import com.dropbox.componentbox.foundation.Icon
import com.dropbox.componentbox.foundation.Icons
import com.dropbox.componentbox.foundation.RealVectorRes

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

    actual val home = Icon(
        line = RealVectorRes("Home.Line", R.drawable.ic_dig_home_line),
        fill = RealVectorRes("Home.fill", R.drawable.ic_dig_home_fill),
        pictogram = null,
        spot = null
    )

    actual val image = Icon(
        line = RealVectorRes("Image.Line", R.drawable.ic_dig_image_line),
        fill = RealVectorRes("Image.fill", R.drawable.ic_dig_image_fill),
        pictogram = null,
        spot = null
    )
    actual val upgrade = Icon(
        line = RealVectorRes("Upgrade.Line", R.drawable.ic_dig_upgrade_line),
        fill = null,
        pictogram = null,
        spot = null
    )
    actual val person = Icon(
        line = RealVectorRes("Home.Line", R.drawable.ic_dig_person_line),
        fill = RealVectorRes("Home.fill", R.drawable.ic_dig_person_fill),
        pictogram = null,
        spot = null
    )


    override fun list() = mutableListOf(
        checkmarkCircle,
        fail,
        twinkle2,
        home,
        image,
        upgrade,
        person
    )
}