package com.dropbox.componentbox.discovery.discovery.campaigns.data

import com.dropbox.componentbox.discovery.discovery.campaigns.data.repository.CampaignRepository
import javax.inject.Inject

class CampaignManager @Inject constructor(repository: CampaignRepository) {
    val bestCampaigns: MutableList<Campaign>

    val campaignIdToSeen: MutableMap<String, Boolean> = mutableMapOf()

    inline fun <reified C : Campaign> getBestCampaign(): Campaign? {
        val bestCampaignIndex = bestCampaigns.indexOfFirst { campaign -> campaign::class == C::class }

        if (bestCampaignIndex > -1) {
            val bestCampaign = bestCampaigns.removeAt(bestCampaignIndex)
            campaignIdToSeen[bestCampaign.id()]
            return bestCampaign
        }

        return null
    }

    init {
        bestCampaigns = repository.getBestCampaigns().toMutableList()
    }
}