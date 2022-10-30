package com.dropbox.componentbox.campaigns.android.feature.account.data.impl

import com.dropbox.componentbox.ComponentBox
import com.dropbox.componentbox.campaigns.android.common.scoping.AccountScope
import com.dropbox.componentbox.campaigns.android.common.scoping.SingleIn
import com.dropbox.componentbox.campaigns.android.feature.account.data.AccountCampaignsRepository
import com.dropbox.componentbox.campaigns.android.feature.account.data.Campaign
import com.dropbox.componentbox.campaigns.xplat.componentbox.CampaignsComponentBoxData
import com.dropbox.componentbox.component.Column
import com.dropbox.componentbox.component.Text
import com.dropbox.componentbox.component.TextButton
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@SingleIn(AccountScope::class)
@ContributesBinding(AccountScope::class)
class RealAccountCampaignsRepository @Inject constructor() : AccountCampaignsRepository {
    override suspend fun getBestCampaign(): Campaign<CampaignsComponentBoxData> {
        return Campaign.of(
            data = CampaignsComponentBoxData(
                componentBox = ComponentBox.of(
                    root = Column.of(
                        components = mutableListOf(
                            TextButton.of(
                                components = mutableListOf(
                                    Text.of(text = "Component Box")
                                )
                            )
                        )
                    )
                )
            ),
            manifestUrl = "http://10.0.2.2:8080/manifest.zipline.json"
        )
    }
}

