package com.dropbox.componentbox.ui.surfaces.simulator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dropbox.componentbox.Inflater
import com.dropbox.componentbox.models.BottomTab
import com.dropbox.componentbox.ui.theme.faintText
import com.dropbox.componentbox.ui.theme.standardBackgroundElevated

@Composable
fun bottomNav(inflater: Inflater) {

    val bottomTabs = inflater.bottomTabs()
    val selected = bottomTabs[3]

    fun isSelected(tab: BottomTab) = selected == tab

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(color = MaterialTheme.colors.standardBackgroundElevated)
            .padding(vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        items(bottomTabs.subList(0, 5)) { tab ->
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(
                    painter = painterResource(if (isSelected(tab)) tab.iconSelected.resPath else tab.iconNotSelected.resPath),
                    modifier = Modifier.size(24.dp),
                    tint = if (isSelected(tab)) MaterialTheme.colors.onBackground else MaterialTheme.colors.faintText,
                    contentDescription = null,
                )
                Text(
                    text = tab.title.value,
                    style = MaterialTheme.typography.caption,
                    color = if (isSelected(tab)) MaterialTheme.colors.onBackground else MaterialTheme.colors.faintText,
                    fontSize = 8.sp,
                )
            }
        }
    }
}







