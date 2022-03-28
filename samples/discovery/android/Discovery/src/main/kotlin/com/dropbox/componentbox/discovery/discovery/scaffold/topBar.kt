package com.dropbox.componentbox.discovery.discovery.scaffold

import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun topBar(
    title: String,
    actions: List<@Composable () -> Unit>,
    leadingNavigationIconButton: LeadingNavigationIconButton?
): @Composable () -> Unit {
    return {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.background,
            navigationIcon = { leadingNavigationIconButton?.Inflate() },
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
private fun LeadingNavigationIconButton.Inflate() {
    IconButton(onClick = action) {
        Icon(
            painter = painterResource(icon),
            modifier = Modifier.size(32.dp),
            contentDescription = null,
            tint = MaterialTheme.colors.onBackground
        )
    }
}