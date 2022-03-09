package com.dropbox.componentbox.discovery.discovery.account.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.discovery.theme.R
import com.dropbox.componentbox.samples.discovery.color.disabledBackground

@Composable
fun AccountBanner(callback: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFEF4D4))
    ) {

        Image(
            painter = painterResource(id = R.drawable.roadblock),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(108.dp),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "You are almost out of storage",
                style = MaterialTheme.typography.h6
            )

            Text(
                text = "Try Dropbox Plus free for 30 days, then pay \$11.99/month for the space you need to keep your files safe.",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(vertical = 4.dp)
            )


            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Button(
                    onClick = { callback() },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.disabledBackground),
                    modifier = Modifier
                        .padding(end = 2.dp)
                        .width(160.dp),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Text(text = "Dismiss", modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp))
                }

                Button(
                    onClick = { /*TODO*/ },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                    modifier = Modifier
                        .padding(start = 2.dp)
                        .width(160.dp),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Text(
                        text = "Learn more",
                        color = MaterialTheme.colors.onPrimary,
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp)
                    )
                }
            }
        }

    }
}