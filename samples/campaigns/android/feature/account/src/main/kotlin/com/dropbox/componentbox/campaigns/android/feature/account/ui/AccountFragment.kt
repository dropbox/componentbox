package com.dropbox.componentbox.campaigns.android.feature.account.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.fragmentViewModel
import com.dropbox.componentbox.campaigns.android.common.binding.bindings
import com.dropbox.componentbox.campaigns.android.common.binding.fragmentComponent
import com.dropbox.componentbox.campaigns.android.common.scoping.ComponentHolder
import com.dropbox.componentbox.campaigns.android.feature.account.ui.wiring.AccountComponent
import com.dropbox.componentbox.campaigns.xplat.componentbox.CampaignsComponentBoxDestination
import com.dropbox.componentbox.campaigns.xplat.componentbox.CampaignsComponentBoxState
import com.dropbox.componentbox.material.material
import com.dropbox.componentbox.ui.ComponentBoxKit


class AccountFragment : Fragment(), MavericksView, ComponentHolder {
    private val viewModel: AccountCampaignsViewModel by fragmentViewModel()
    private lateinit var kit: ComponentBoxKit

    override val component by fragmentComponent { _, _ ->
        requireActivity().bindings<AccountComponent.ParentBindings>()
            .accountComponentBuilder()
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindNavigation()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)

        return ComposeView(requireActivity()).apply {
            setContent {
                val componentBox = viewModel.collectAsState().value.root
                componentBox?.material(kit)
            }
        }
    }

    private fun bindNavigation() {
        viewModel.onEach(CampaignsComponentBoxState::destination) { destination ->
            destination?.let { navigate(destination) }
        }
    }

    private fun navigate(destination: CampaignsComponentBoxDestination) {
        when (destination) {
            CampaignsComponentBoxDestination.Iap.PlanCompare -> TODO()
        }
    }

    override fun invalidate() {}
}