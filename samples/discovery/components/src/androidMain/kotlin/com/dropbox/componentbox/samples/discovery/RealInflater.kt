package com.dropbox.componentbox.samples.discovery

import androidx.compose.runtime.Composable
import com.dropbox.componentbox.Inflater
import com.dropbox.componentbox.models.BottomTab
import com.dropbox.componentbox.models.Component
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
                iconSelected = discoveryIcons.twinkle2.fill ?: discoveryIcons.twinkle2.line,
                iconNotSelected = discoveryIcons.twinkle2.line,
                title = Strings.home_tab
            ),
            BottomTab(
                id = DiscoveryDestination.Photos,
                iconSelected = discoveryIcons.twinkle2.fill ?: discoveryIcons.twinkle2.line,
                iconNotSelected = discoveryIcons.twinkle2.line,
                title = Strings.photos_tab
            ),
            BottomTab(
                id = DiscoveryDestination.Plans,
                iconSelected = discoveryIcons.twinkle2.fill ?: discoveryIcons.twinkle2.line,
                iconNotSelected = discoveryIcons.twinkle2.line,
                title = Strings.plans_tab
            ),
            BottomTab(
                id = DiscoveryDestination.Account,
                iconSelected = discoveryIcons.twinkle2.fill ?: discoveryIcons.twinkle2.line,
                iconNotSelected = discoveryIcons.twinkle2.line,
                title = Strings.account_tab
            )
        )
    }
}