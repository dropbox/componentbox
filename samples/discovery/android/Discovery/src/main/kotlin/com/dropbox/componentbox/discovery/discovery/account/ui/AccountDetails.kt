package com.dropbox.componentbox.discovery.discovery.account.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.discovery.theme.R
import com.dropbox.componentbox.samples.discovery.color.disabledBackground
import com.dropbox.componentbox.samples.discovery.color.faintText
import com.dropbox.componentbox.samples.discovery.color.standardBackgroundElevated
import com.dropbox.componentbox.samples.discovery.color.standardText

@Composable
fun AccountDetails() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        EffectivePlan(FAKE_PLAN_NAME) {
            UpgradeButton()
        }

        Spacer(modifier = Modifier.size(16.dp))

        Divider(color = MaterialTheme.colors.disabledBackground, thickness = 0.8.dp)

        Spacer(modifier = Modifier.size(16.dp))
        EffectivePlanStats(storageUsed = "1.5GB", connectedDevices = "2/3")
        Spacer(modifier = Modifier.size(16.dp))
        Row {
            Button(
                onClick = { /*TODO*/ },
                shape = RectangleShape,
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.disabledBackground),
                modifier = Modifier
                    .fillMaxWidth(),
                elevation = ButtonDefaults.elevation(0.dp)
            ) {

                Text(
                    text = "Account details",
                    color = MaterialTheme.colors.standardText,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }

    }
}


@Composable
fun EffectivePlan(planName: String, Button: (@Composable () -> Unit)? = null) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.dig_dropbox_logo),
                tint = MaterialTheme.colors.primary,
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )


            Text(
                text = planName,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 8.dp),
                color = MaterialTheme.colors.standardText
            )
        }

        if (Button != null) {
            Button()
        }
    }
}


@Composable
fun EffectivePlanStats(storageUsed: String, connectedDevices: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 40.dp, max = 80.dp),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_dig_space_line),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                tint = MaterialTheme.colors.standardText
            )

            Column {
                Text(text = storageUsed, style = MaterialTheme.typography.h4)

                Text(text = "Storage used", style = MaterialTheme.typography.body1)
            }
        }


        Divider(
            color = MaterialTheme.colors.disabledBackground, modifier = Modifier
                .fillMaxHeight()
                .width(0.8.dp)
        )

        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(
                painter = painterResource(id = R.drawable.ic_dig_mobile_line),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
                tint = MaterialTheme.colors.standardText
            )

            Column {
                Text(text = connectedDevices, style = MaterialTheme.typography.h4)

                Text(text = "Devices linked", style = MaterialTheme.typography.body1)
            }
        }
    }
}


@Composable
fun UpgradeButton() {
    Button(
        onClick = { /*TODO*/ },
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
    ) {

        Text(
            text = "Upgrade",
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.button,
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}

private const val FAKE_PLAN_NAME = "Dropbox Basic"