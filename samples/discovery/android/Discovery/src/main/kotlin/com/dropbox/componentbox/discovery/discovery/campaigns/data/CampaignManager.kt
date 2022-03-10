package com.dropbox.componentbox.discovery.discovery.campaigns.data

import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.Campaign
import com.dropbox.componentbox.discovery.discovery.campaigns.data.repository.CampaignRepository
import com.dropbox.componentbox.discovery.discovery.util.id
import javax.inject.Inject

class CampaignManager @Inject constructor(repository: CampaignRepository) {
    val bestCampaigns: MutableList<Campaign>
    val campaignIdToSeen: MutableMap<String, Boolean> = mutableMapOf()

    inline fun <reified C : Campaign> getBestCampaign(): Campaign? {
        val bestCampaignIndex = bestCampaigns.indexOfFirst { campaign -> campaign is C }

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