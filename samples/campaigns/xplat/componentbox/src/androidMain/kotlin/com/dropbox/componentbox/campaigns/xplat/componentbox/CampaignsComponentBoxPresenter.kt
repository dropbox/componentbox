package com.dropbox.componentbox.campaigns.xplat.componentbox

import com.dropbox.componentbox.model.ComponentBoxPresenter

abstract class CampaignsComponentBoxPresenter(
    initialState: CampaignsComponentBoxState,
) : ComponentBoxPresenter<CampaignsComponentBoxData, CampaignsComponentBoxModel, CampaignsComponentBoxState, CampaignsComponentBoxEvent>(
    initialState = initialState
)