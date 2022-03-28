package com.dropbox.componentbox.discovery.discovery.scaffold

import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dropbox.componentbox.discovery.android.R
import kotlinx.coroutines.launch
import androidx.compose.runtime.CompositionLocalProvider

import java.util.logging.Logger.global


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Scaffold() {
    val presenter: ScaffoldPresenter = hiltViewModel()

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(initialValue = BottomSheetValue.Collapsed)
    )

    val coroutineScope = rememberCoroutineScope()

    val tabs = presenter.inflater.bottomTabs()
    val (selectedTab, setSelectedTab) = remember { mutableStateOf(tabs[3]) }
    val title = remember { mutableStateOf("") }

    val defaultLeadingNavigationIconButton = LeadingNavigationIconButton(R.drawable.ic_dig_list_view_line) {}
    val leadingNavigationIconButton: MutableState<LeadingNavigationIconButton> =
        remember { mutableStateOf(defaultLeadingNavigationIconButton) }

    val topBarActions = remember { mutableStateListOf<@Composable () -> Unit>() }

    val bottomSheetContent = remember {
        mutableStateOf<@Composable () -> Unit>({
            Text(text = "Bottom sheet")
        })
    }
    val sheetGesturesEnabled = remember { mutableStateOf(false) }

    val callback = object : ScaffoldCallback {
        override fun setTitle(value: String) {
            title.value = value
        }

        override fun setTopBarActions(value: List<@Composable () -> Unit>) {
            topBarActions.clear()
            topBarActions.addAll(value)
        }

        override fun setLeadingNavigationIconButton(value: LeadingNavigationIconButton) {
            leadingNavigationIconButton.value = value
        }

        override fun expandBottomSheet() {
            coroutineScope.launch {
                bottomSheetScaffoldState.bottomSheetState.expand()
            }
        }

        override fun collapseBottomSheet() {
            coroutineScope.launch {
                bottomSheetScaffoldState.bottomSheetState.collapse()
            }
        }

        override fun setBottomSheet(content: @Composable () -> Unit) {
            bottomSheetContent.value = content
        }

        override fun enableSheetGestures() {
            sheetGesturesEnabled.value = true
        }

        override fun disableSheetGestures() {
            sheetGesturesEnabled.value = false
        }
    }


    BottomSheetScaffold(
        scaffoldState = bottomSheetScaffoldState,
        sheetContent = { bottomSheetContent.value() },
        sheetGesturesEnabled = sheetGesturesEnabled.value,
        sheetPeekHeight = 0.dp
    )
    {
        Scaffold(
            topBar = topBar(title.value, topBarActions, leadingNavigationIconButton.value),
            bottomBar = bottomBar(tabs, selectedTab) { setSelectedTab(it) }
        ) { innerPadding ->
            Screen(innerPadding, selectedTab, callback)
        }

    }
}

data class LeadingNavigationIconButton(
    @DrawableRes val icon: Int,
    val action: () -> Unit
)