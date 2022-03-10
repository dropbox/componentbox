package com.dropbox.componentbox.discovery.discovery.campaigns.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil.compose.rememberImagePainter
import com.dropbox.componentbox.discovery.discovery.campaigns.data.entities.Campaign
import com.dropbox.componentbox.samples.discovery.color.disabledBackground


@Composable
fun Campaign.Modal.PromptModal.Inflate(onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Surface(
            elevation = 2.dp,
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier.padding(vertical = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = rememberImagePainter(imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .height(220.dp),
                    contentScale = ContentScale.FillHeight,
                )

                Column(
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(text = text, style = MaterialTheme.typography.h5)
                    Text(text = subtext, style = MaterialTheme.typography.body1)
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RectangleShape,
                        elevation = ButtonDefaults.elevation(0.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = confirmText,
                            style = MaterialTheme.typography.button,
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                    Button(
                        onClick = onDismiss,
                        shape = RectangleShape,
                        elevation = ButtonDefaults.elevation(0.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.disabledBackground),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = dismissText,
                            style = MaterialTheme.typography.button,
                            color = MaterialTheme.colors.onBackground
                        )
                    }
                }
            }
        }
    }
}