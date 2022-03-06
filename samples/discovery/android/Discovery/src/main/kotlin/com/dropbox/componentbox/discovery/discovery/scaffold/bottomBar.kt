package com.dropbox.componentbox.discovery.discovery.scaffold

import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.models.BottomTab
import com.dropbox.componentbox.samples.discovery.color.standardBackgroundElevated

@Composable
fun bottomBar(
    tabs: List<BottomTab>,
    selectedTab: BottomTab,
    onClick: (tab: BottomTab) -> Unit
): @Composable () -> Unit {
    return {
        BottomNavigation(
            backgroundColor = MaterialTheme.colors.standardBackgroundElevated,
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            tabs.forEach { tab ->
                BottomNavigationItem(
                    selected = tab == selectedTab,
                    onClick = { onClick(tab) },
                    icon = {
                        Icon(
                            painter = painterResource(id = if (tab == selectedTab) tab.iconSelected.resId else tab.iconNotSelected.resId),
                            contentDescription = null
                        )
                    },
                    label = { Text(text = stringResource(id = tab.title.resId)) }
                )
            }
        }
    }
}