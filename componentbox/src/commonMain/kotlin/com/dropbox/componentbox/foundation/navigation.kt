package com.dropbox.componentbox.foundation

open class Destination

data class BottomTab(
    val id: Destination,
    val title: StringRes,
    val iconSelected: VectorRes,
    val iconNotSelected: VectorRes
)