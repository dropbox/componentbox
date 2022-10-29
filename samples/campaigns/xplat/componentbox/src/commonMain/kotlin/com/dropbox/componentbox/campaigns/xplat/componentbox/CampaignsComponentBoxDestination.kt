package com.dropbox.componentbox.campaigns.xplat.componentbox

sealed class CampaignsComponentBoxDestination {
    sealed class Iap : CampaignsComponentBoxDestination() {
        object PlanCompare : Iap()
    }
}