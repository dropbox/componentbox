package com.dropbox.componentbox.discovery.discovery.scaffold

import androidx.lifecycle.ViewModel
import com.dropbox.componentbox.Inflater
import com.dropbox.componentbox.discovery.discovery.scoping.AppScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScaffoldPresenter @Inject constructor(appScope: AppScope) : ViewModel() {
    val inflater: Inflater

    init {
        inflater = appScope.inflater
    }
}