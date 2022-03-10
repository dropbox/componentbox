package com.dropbox.componentbox.discovery.discovery.account.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.discovery.theme.R

@Composable
fun AccountBanner(callback: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFFEF4D4))
    ) {

        Box {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
                IconButton(onClick = callback) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_dig_close_line),
                        contentDescription = null,
                        modifier = Modifier.size(32.dp)
                    )
                }
            }

            Image(
                painter = painterResource(id = R.drawable.roadblock),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                contentScale = ContentScale.Crop
            )
        }



        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.onBackground)
                .padding(horizontal = 16.dp)

        ) {
            Text(
                text = "You are almost out of storage",
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.background
            )

            Text(
                text = "Try Dropbox Plus free for 30 days, then pay \$11.99/month for the space you need to keep your files safe.",
                style = MaterialTheme.typography.body2,
                modifier = Modifier.padding(vertical = 4.dp),
                color = MaterialTheme.colors.background
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Button(
                    onClick = { callback() },
                    shape = RectangleShape,
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                    modifier = Modifier
                        .padding(end = 2.dp)
                        .fillMaxWidth(),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Text(
                        text = "Explore Plus",
                        modifier = Modifier.padding(vertical = 4.dp, horizontal = 16.dp),
                        color = MaterialTheme.colors.background,
                        style = MaterialTheme.typography.button,
                    )
                }
            }
        }

    }
}