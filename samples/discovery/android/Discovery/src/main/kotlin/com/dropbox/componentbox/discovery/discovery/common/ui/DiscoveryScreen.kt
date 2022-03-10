package com.dropbox.componentbox.discovery.discovery.common.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.dropbox.componentbox.discovery.discovery.DiscoveryPresenter
import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.Campaign
import com.dropbox.componentbox.discovery.discovery.scaffold.ScaffoldCallback
import com.dropbox.componentbox.discovery.discovery.util.setUpScreen

@Composable
fun DiscoveryScreen(
    title: String,
    scaffoldCallback: ScaffoldCallback,
    TopBarActions: List<@Composable () -> Unit>,
    LazyColumn: @Composable (@Composable () -> Unit) -> Unit,
) {
    scaffoldCallback.setUpScreen(title = title, TopBarActions = TopBarActions)

    val presenter: DiscoveryPresenter = mavericksViewModel()

    Box {
        LazyColumn {
            if (presenter.canShowBanner.collectAsState().value) {
                presenter.bestBanner.collectAsState().value?.Inflate {
                    presenter.dismissCampaign<Campaign.Banner>()
                }
            }
        }


        presenter.bestModal.collectAsState().value?.Inflate {
            presenter.dismissCampaign<Campaign.Modal>()
        }
    }
}