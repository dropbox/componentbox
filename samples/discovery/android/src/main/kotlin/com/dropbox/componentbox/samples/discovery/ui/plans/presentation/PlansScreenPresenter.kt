package com.dropbox.componentbox.samples.discovery.ui.plans.presentation

import androidx.lifecycle.ViewModel
import com.dropbox.componentbox.samples.discovery.DiscoveryEvent
import com.dropbox.componentbox.samples.discovery.DiscoveryZipline
import com.dropbox.componentbox.samples.discovery.Sample
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

@HiltViewModel
class PlansScreenPresenter @Inject constructor(zipline: DiscoveryZipline) : ViewModel() {
    val models = MutableStateFlow(Sample.viewModel)

    init {
        val scope = MainScope()
        val events = MutableSharedFlow<DiscoveryEvent>(extraBufferCapacity = Int.MAX_VALUE)
        zipline.produceModelsIn(scope, events, models)
    }
}