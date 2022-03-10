package com.dropbox.componentbox.discovery.discovery.account.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.dropbox.componentbox.discovery.discovery.scoping.AppScope
import com.dropbox.componentbox.models.BottomTab
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AccountPresenter @Inject constructor(private val appScope: AppScope) : ViewModel() {
    lateinit var tabs: List<BottomTab>

    var title = ""
    var topBarActions = mutableStateListOf<@Composable () -> Unit>()
    var selectedTab = if (tabs.isNotEmpty()) tabs[tabs.size - 1] else null

    @Composable
    fun load() {
        tabs = appScope.inflater.bottomTabs()
    }
}





