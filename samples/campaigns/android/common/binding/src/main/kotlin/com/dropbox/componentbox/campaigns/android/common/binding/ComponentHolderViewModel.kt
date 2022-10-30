package com.dropbox.componentbox.campaigns.android.common.binding

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import java.util.concurrent.ConcurrentHashMap

@PublishedApi
internal class ComponentHolderViewModel(app: Application) : AndroidViewModel(app) {
    val map = ConcurrentHashMap<Class<*>, Any>()

    inline fun <reified T> get(factory: (CoroutineScope, Application) -> T): T {
        return map.getOrPut(T::class.java) { factory(viewModelScope, getApplication()) } as T
    }
}