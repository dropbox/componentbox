package com.dropbox.componentbox.samples.discovery.ui.scaffold

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dropbox.componentbox.Inflater
import com.dropbox.componentbox.models.BottomTab
import com.dropbox.componentbox.samples.discovery.DiscoveryDestination
import com.dropbox.componentbox.samples.discovery.ui.account.AccountScreen
import com.dropbox.componentbox.samples.discovery.ui.files.FilesScreen
import com.dropbox.componentbox.samples.discovery.ui.home.HomeScreen
import com.dropbox.componentbox.samples.discovery.ui.photos.PhotosScreen
import com.dropbox.componentbox.samples.discovery.ui.plans.view.PlansScreen

@Composable
fun Screen(innerPadding: PaddingValues, inflater: Inflater, selectedTab: BottomTab, callback: ScaffoldCallback) {
    Box(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
    ) {
        when (selectedTab.id) {
            DiscoveryDestination.Home -> HomeScreen(inflater, callback)
            DiscoveryDestination.Files -> FilesScreen(inflater, callback)
            DiscoveryDestination.Photos -> PhotosScreen(inflater, callback)
            DiscoveryDestination.Plans -> PlansScreen(inflater, callback)
            DiscoveryDestination.Account -> AccountScreen(inflater, callback)
        }
    }
}