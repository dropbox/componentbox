package com.dropbox.componentbox.campaigns.android.feature.account.ui

import com.airbnb.mvrx.MavericksViewModelFactory
import com.dropbox.componentbox.campaigns.android.common.annotation.ContributesViewModel
import com.dropbox.componentbox.campaigns.android.common.binding.daggerMavericksViewModelFactory
import com.dropbox.componentbox.campaigns.android.common.scoping.AccountScope
import com.dropbox.componentbox.campaigns.android.feature.account.data.AccountCampaignsRepository
import com.dropbox.componentbox.campaigns.android.feature.account.data.operator.asComponentBoxNetworkResponse
import com.dropbox.componentbox.campaigns.xplat.componentbox.CampaignsComponentBoxData
import com.dropbox.componentbox.campaigns.xplat.componentbox.CampaignsComponentBoxPresenter
import com.dropbox.componentbox.campaigns.xplat.componentbox.CampaignsComponentBoxState
import com.dropbox.componentbox.campaigns.xplat.componentbox.ComponentBoxDefaults
import com.dropbox.componentbox.model.ComponentBoxNetworkResponse
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@ContributesViewModel(AccountScope::class)
class AccountCampaignsViewModel @AssistedInject constructor(
    @Assisted initialState: CampaignsComponentBoxState,
    private val repository: AccountCampaignsRepository
) : CampaignsComponentBoxPresenter(initialState) {
    override val serviceName: String = ComponentBoxDefaults.SERVICE_NAME
    override val applicationName: String = ComponentBoxDefaults.APPLICATION_NAME
    override val fetcher: suspend () -> ComponentBoxNetworkResponse<CampaignsComponentBoxData> =
        { fetch() }

    private suspend fun fetch(): ComponentBoxNetworkResponse<CampaignsComponentBoxData> =
        repository.getBestCampaign().asComponentBoxNetworkResponse()

    companion object :
        MavericksViewModelFactory<AccountCampaignsViewModel, CampaignsComponentBoxState> by daggerMavericksViewModelFactory()
}