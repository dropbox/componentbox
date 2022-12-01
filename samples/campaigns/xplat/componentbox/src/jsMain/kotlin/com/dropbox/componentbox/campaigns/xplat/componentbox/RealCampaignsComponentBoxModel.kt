package com.dropbox.componentbox.campaigns.xplat.componentbox

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class RealCampaignsComponentBoxModel : CampaignsComponentBoxModel {
    override fun launch(
        data: CampaignsComponentBoxData,
        events: Flow<CampaignsComponentBoxEvent>,
        scope: CoroutineScope,
    ): StateFlow<CampaignsComponentBoxState> {
        val mutableStateFlow = MutableStateFlow(CampaignsComponentBoxState())

        scope.launch {
            events.collectLatest { event ->
                when (event) {
                    is CampaignsComponentBoxEvent.Navigate -> {
                        val prevState = mutableStateFlow.value
                        val nextState = CampaignsComponentBoxState(
                            root = prevState.root,
                            destination = event.destination
                        )
                        mutableStateFlow.value = nextState
                    }
                }
            }
        }

        return mutableStateFlow
    }
}