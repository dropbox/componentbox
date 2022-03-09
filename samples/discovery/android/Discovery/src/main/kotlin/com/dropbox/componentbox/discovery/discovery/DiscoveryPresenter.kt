package com.dropbox.componentbox.discovery.discovery

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.Campaign
import com.dropbox.componentbox.discovery.discovery.scoping.UserScope
import com.dropbox.componentbox.discovery.discovery.scoping.userScope
import kotlinx.coroutines.flow.MutableStateFlow

class DiscoveryPresenter(
    initialState: DiscoveryState,
    val userScope: UserScope
) : MavericksViewModel<DiscoveryState>(initialState) {

    var bestBanner = MutableStateFlow<Campaign.Banner?>(null)
    var bestModal = MutableStateFlow<Campaign.Modal?>(null)

    var canShowBanner = MutableStateFlow(true)
    var canShowModal = MutableStateFlow(true)

    init {
        bestBanner.value = getBestCampaign()
        bestModal.value = getBestCampaign()
    }

    inline fun <reified C : Campaign> getBestCampaign(): C? =
        userScope.campaignManager.getBestCampaign<C>() as C?

    inline fun <reified C : Campaign> dismissCampaign() {
        when (C::class) {
            Campaign.Banner::class -> {
                canShowBanner.value = false
                bestBanner.value = getBestCampaign()
                canShowBanner.value = true
            }
            Campaign.Modal::class -> {
                canShowModal.value = false
                bestModal.value = getBestCampaign()
            }
        }
    }

    companion object : MavericksViewModelFactory<DiscoveryPresenter, DiscoveryState> {
        override fun initialState(viewModelContext: ViewModelContext): DiscoveryState {
            return DiscoveryState(DiscoveryViewState.Loading)
        }

        override fun create(viewModelContext: ViewModelContext, state: DiscoveryState): DiscoveryPresenter {
            return DiscoveryPresenter(state, userScope())
        }
    }
}

data class DiscoveryState(
    val viewState: DiscoveryViewState,
) : MavericksState

sealed class DiscoveryViewState {
    object Loading : DiscoveryViewState()
    object Success : DiscoveryViewState()
}