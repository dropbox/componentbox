package com.dropbox.componentbox.zipline

import app.cash.zipline.ZiplineService
import com.dropbox.componentbox.foundation.ComponentBox
import com.dropbox.componentbox.foundation.ComponentBoxType
import com.dropbox.componentbox.presentation.ComponentBoxViewModel
import kotlinx.coroutines.flow.Flow

interface ComponentBoxZiplineService : ZiplineService {
    suspend fun produceModelsInBanner(
        type: ComponentBoxType,
        url: String,
        headers: Map<String, String> = mapOf()
    ): Flow<ComponentBoxViewModel<ComponentBox.Banner>>

    suspend fun produceModelsInModal(
        type: ComponentBoxType,
        url: String,
        headers: Map<String, String> = mapOf()
    ): Flow<ComponentBoxViewModel<ComponentBox.Modal>>

    suspend fun produceModelsInScreen(
        type: ComponentBoxType,
        url: String,
        headers: Map<String, String> = mapOf()
    ): Flow<ComponentBoxViewModel<ComponentBox.Screen>>
}


suspend inline fun <reified C : ComponentBox> ComponentBoxZiplineService.produceModels(
    url: String,
    headers: Map<String, String>
): Flow<ComponentBoxViewModel<C>>? {
    return when (C::class) {
        ComponentBox.Banner::class -> this.produceModelsInBanner(
            ComponentBoxType.Banner,
            url,
            headers
        ) as Flow<ComponentBoxViewModel<C>>
        ComponentBox.Modal::class -> this.produceModelsInModal(
            ComponentBoxType.Modal,
            url,
            headers
        ) as Flow<ComponentBoxViewModel<C>>
        ComponentBox.Screen::class -> this.produceModelsInScreen(
            ComponentBoxType.Screen,
            url,
            headers
        ) as Flow<ComponentBoxViewModel<C>>
        else -> null
    }
}