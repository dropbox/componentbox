package com.dropbox.componentbox.zipline

import app.cash.zipline.ZiplineService


interface ComponentBoxService<Model : ComponentBoxModel<State>, State : ComponentBoxState> : ZiplineService {
    val componentBoxUrl: String
    suspend fun load(manifestUrl: String): Model
}