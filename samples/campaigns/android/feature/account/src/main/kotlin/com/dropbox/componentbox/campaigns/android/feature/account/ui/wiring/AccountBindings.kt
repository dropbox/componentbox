package com.dropbox.componentbox.campaigns.android.feature.account.ui.wiring

import com.dropbox.componentbox.campaigns.android.common.scoping.AccountScope
import com.dropbox.componentbox.campaigns.android.feature.account.data.AccountCampaignsRepository
import com.squareup.anvil.annotations.ContributesTo

@ContributesTo(AccountScope::class)
interface AccountBindings {
    val accountCampaignsRepository: AccountCampaignsRepository
}