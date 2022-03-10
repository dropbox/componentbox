package com.dropbox.componentbox.discovery.discovery.scaffold

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.discovery.android.R

@Composable
fun topBar(title: String, actions: List<@Composable () -> Unit>): @Composable () -> Unit {
    return {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.background,
            navigationIcon = topBarNavigationIcon(),
            title = topBarTitle(title),
            actions = {
                actions.forEach { action ->
                    action()
                }
            }
        )
    }
}

@Composable
private fun topBarTitle(title: String): @Composable () -> Unit {
    return {
        Text(
            text = title,
            color = MaterialTheme.colors.onBackground,
            style = MaterialTheme.typography.h5,
            textAlign = TextAlign.Start
        )
    }
}

@Composable
private fun topBarNavigationIcon(): @Composable () -> Unit {
    return {
        Icon(
            painter = painterResource(R.drawable.ic_dig_list_view_line),
            modifier = Modifier.size(32.dp),
            contentDescription = null,
            tint = MaterialTheme.colors.onBackground
        )
    }
}