package com.dropbox.componentbox.campaigns.android.common.binding

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.CoroutineScope

inline fun <reified T : Any> Fragment.fragmentComponent(crossinline factory: (CoroutineScope, Application) -> T) =
    lazy {
        ViewModelProvider(this)[ComponentHolderViewModel::class.java].get(factory)
    }