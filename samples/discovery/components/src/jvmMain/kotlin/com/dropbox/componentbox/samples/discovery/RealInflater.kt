package com.dropbox.componentbox.samples.discovery

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.foundation.Inflater
import com.dropbox.componentbox.foundation.BottomTab
import com.dropbox.componentbox.foundation.Component
import com.dropbox.componentbox.samples.discovery.vector.DiscoveryIcons

actual class RealInflater : Inflater {
    @Composable
    override fun Inflate(component: Component) {
        component.Inflate()
    }

    @Composable
    override fun bottomTabs(): List<BottomTab> {
        val discoveryIcons = DiscoveryIcons()

        return listOf(
            BottomTab(
                id = DiscoveryDestination.Home,
                title = Strings.home_tab,
                iconSelected = discoveryIcons.twinkle2.fill ?: discoveryIcons.twinkle2.line,
                iconNotSelected = discoveryIcons.twinkle2.line
            ),
            BottomTab(
                id = DiscoveryDestination.Photos,
                title = Strings.photos_tab,
                iconSelected = discoveryIcons.twinkle2.fill ?: discoveryIcons.twinkle2.line,
                iconNotSelected = discoveryIcons.twinkle2.line,
            ),
            BottomTab(
                id = DiscoveryDestination.Plans,
                title = Strings.plans_tab,
                iconSelected = discoveryIcons.twinkle2.fill ?: discoveryIcons.twinkle2.line,
                iconNotSelected = discoveryIcons.twinkle2.line,
            ),
            BottomTab(
                id = DiscoveryDestination.Account,
                title = Strings.account_tab,
                iconSelected = discoveryIcons.twinkle2.fill ?: discoveryIcons.twinkle2.line,
                iconNotSelected = discoveryIcons.twinkle2.line,
            ),
        )
    }
}