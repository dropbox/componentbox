package com.dropbox.componentbox.discovery.discovery.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dropbox.componentbox.models.BottomTab
import com.dropbox.componentbox.samples.discovery.DiscoveryDestination
import com.dropbox.componentbox.discovery.discovery.account.ui.AccountScreen
import com.dropbox.componentbox.discovery.discovery.home.ui.HomeScreen
import com.dropbox.componentbox.discovery.discovery.photos.ui.PhotosScreen
import com.dropbox.componentbox.discovery.discovery.plans.ui.PlansScreen

@Composable
fun Screen(innerPadding: PaddingValues, selectedTab: BottomTab, callback: ScaffoldCallback) {
    Box(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        when (selectedTab.id) {
            DiscoveryDestination.Home -> HomeScreen(callback)
            DiscoveryDestination.Photos -> PhotosScreen(callback)
            DiscoveryDestination.Plans -> PlansScreen(callback)
            DiscoveryDestination.Account -> AccountScreen(callback)
        }
    }
}