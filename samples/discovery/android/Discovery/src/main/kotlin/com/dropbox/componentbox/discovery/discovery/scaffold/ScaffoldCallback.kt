package com.dropbox.componentbox.discovery.discovery.scaffold

import androidx.compose.runtime.Composable

interface ScaffoldCallback {
    fun setTitle(value: String)
    fun setLeadingNavigationIconButton(value: LeadingNavigationIconButton)
    fun setTopBarActions(value: List<@Composable () -> Unit>)
    fun setBottomSheet(content: @Composable () -> Unit)
    fun expandBottomSheet()
    fun collapseBottomSheet()
    fun enableSheetGestures()
    fun disableSheetGestures()
}