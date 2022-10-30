package com.dropbox.componentbox.campaigns.android.feature.account.ui

import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MavericksViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.dropbox.componentbox.campaigns.android.common.binding.bindings
import com.dropbox.componentbox.campaigns.android.common.scoping.ComponentHolder
import com.dropbox.componentbox.campaigns.android.feature.account.data.AccountCampaignsRepository
import com.dropbox.componentbox.campaigns.android.feature.account.data.operator.asComponentBoxNetworkResponse
import com.dropbox.componentbox.campaigns.android.feature.account.ui.wiring.AccountBindings
import com.dropbox.componentbox.campaigns.android.feature.account.ui.wiring.AccountComponent
import com.dropbox.componentbox.campaigns.xplat.componentbox.CampaignsComponentBoxData
import com.dropbox.componentbox.campaigns.xplat.componentbox.CampaignsComponentBoxPresenter
import com.dropbox.componentbox.campaigns.xplat.componentbox.CampaignsComponentBoxService
import com.dropbox.componentbox.campaigns.xplat.componentbox.CampaignsComponentBoxState
import com.dropbox.componentbox.campaigns.xplat.componentbox.ComponentBoxDefaults
import com.dropbox.componentbox.model.ComponentBoxNetworkResponse

class AccountCampaignsViewModel(
    initialState: CampaignsComponentBoxState,
    private val repository: AccountCampaignsRepository,
    override val component: AccountComponent
) : CampaignsComponentBoxPresenter(initialState), ComponentHolder {

    override val serviceName: String = ComponentBoxDefaults.SERVICE_NAME
    override val applicationName: String = ComponentBoxDefaults.APPLICATION_NAME
    override val fetcher: suspend () -> ComponentBoxNetworkResponse<CampaignsComponentBoxData> =
        { fetch() }

    private suspend fun fetch(): ComponentBoxNetworkResponse<CampaignsComponentBoxData> =
        repository.getBestCampaign().asComponentBoxNetworkResponse()

    init {
        launch<CampaignsComponentBoxService> { }
    }

    companion object :
        MavericksViewModelFactory<AccountCampaignsViewModel, CampaignsComponentBoxState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: CampaignsComponentBoxState
        ): AccountCampaignsViewModel {

            val fragmentViewModelContext = viewModelContext as FragmentViewModelContext
            val fragment = fragmentViewModelContext.fragment<AccountFragment>()
            val repository = fragment.bindings<AccountBindings>().accountCampaignsRepository

            val accountComponent =
                fragment.bindings<AccountComponent.ParentBindings>()
                    .accountComponentBuilder().build()

            return AccountCampaignsViewModel(state, repository, accountComponent)
        }

        override fun initialState(viewModelContext: ViewModelContext): CampaignsComponentBoxState {
            return CampaignsComponentBoxState(root = null, destination = null)
        }
    }
}