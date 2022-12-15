package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.component.Column
import com.dropbox.componentbox.component.Text
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FakeCampaignsComponentBoxModel : CampaignsComponentBoxModel {
    override fun present(events: Flow<CampaignsComponentBoxEvent>): StateFlow<CampaignsComponentBoxState> = MutableStateFlow(
        CampaignsComponentBoxState(
            componentBox = ComponentBox.of(
                root = Column.of(
                    components = mutableListOf(
                        Text.of(text = "Component Box")
                    )
                )
            )
        )
    )

}