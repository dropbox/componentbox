package com.dropbox.componentbox.campaigns.android.inject

import com.dropbox.componentbox.campaigns.android.common.user.CampaignsUser

data class RealCampaignsUser(
    override val id: String,
    override val name: String,
    override val email: String
) : CampaignsUser