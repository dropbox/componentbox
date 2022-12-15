package com.dropbox.componentbox.samples.campaigns.common.componentbox.zipline

import app.cash.zipline.ZiplineService
import kotlinx.coroutines.flow.Flow

interface CampaignsComponentBoxService : ZiplineService {
    fun flowOfComponentBoxUrls(): Flow<String>
//    fun loadComponentBoxModel(): Flow<CampaignsComponentBoxModel>
}