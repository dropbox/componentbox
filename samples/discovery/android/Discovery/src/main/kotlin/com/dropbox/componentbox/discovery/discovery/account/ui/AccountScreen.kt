package com.dropbox.componentbox.discovery.discovery.account.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dropbox.componentbox.discovery.discovery.common.ui.DiscoveryScreen
import com.dropbox.componentbox.discovery.discovery.scaffold.ScaffoldCallback
import com.dropbox.componentbox.samples.discovery.color.standardBackgroundElevated

@Composable
fun AccountScreen(scaffoldCallback: ScaffoldCallback) {
    DiscoveryScreen(
        title = TITLE,
        scaffoldCallback = scaffoldCallback,
        TopBarActions = listOf { SettingsButton() }
    ) { Banner ->

        Column {
            Banner()

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colors.standardBackgroundElevated),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                items(1) {
                    CurrentUser()
                    AccountDetails()
                    AccountFeatures()
                    AlsoFromDropbox()
                    AccountSettings()
                }
            }
        }
    }
}

private const val TITLE = "Account"
