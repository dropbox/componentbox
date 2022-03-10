package com.dropbox.componentbox.discovery.discovery.account.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment

@Composable
fun UserNameAndEmail(name: String, email: String) {
    Column(horizontalAlignment = Alignment.Start) {
        Text(text = name, style = MaterialTheme.typography.h6)
        Text(text = email, style = MaterialTheme.typography.body2)
    }
}