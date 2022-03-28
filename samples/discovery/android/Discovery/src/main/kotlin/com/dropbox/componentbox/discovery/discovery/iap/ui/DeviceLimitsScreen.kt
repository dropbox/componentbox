@file:OptIn(ExperimentalMaterialApi::class)

package com.dropbox.componentbox.discovery.discovery.iap.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dropbox.componentbox.discovery.android.R
import com.dropbox.componentbox.discovery.discovery.scaffold.LeadingNavigationIconButton
import com.dropbox.componentbox.discovery.discovery.scaffold.ScaffoldCallback
import com.dropbox.componentbox.samples.discovery.color.faintText
import com.dropbox.componentbox.samples.discovery.color.successFill


@Composable
fun getBenefits() = listOf(
    Benefit(
        icon = BenefitIcon(res = R.drawable.info, tint = MaterialTheme.colors.onBackground),
        text = BenefitText(
            res = R.string.device_limits_benefit_one,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Bold
        )
    ),

    Benefit(
        icon = BenefitIcon(res = R.drawable.ic_dig_checkmark_circle_fill, tint = MaterialTheme.colors.successFill),
        text = BenefitText(
            res = R.string.device_limits_benefit_two,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Normal
        )
    ),

    Benefit(
        icon = BenefitIcon(res = R.drawable.ic_dig_checkmark_circle_fill, tint = MaterialTheme.colors.successFill),
        text = BenefitText(
            res = R.string.device_limits_benefit_three,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Normal
        )
    ),

    Benefit(
        icon = BenefitIcon(res = R.drawable.ic_dig_checkmark_circle_fill, tint = MaterialTheme.colors.successFill),
        text = BenefitText(
            res = R.string.device_limits_benefit_four,
            style = MaterialTheme.typography.body1,
            fontWeight = FontWeight.Normal
        )
    )
)


@Composable
fun DeviceLimitsScreen(callback: ScaffoldCallback) {
    callback.setTitle("3 of 3 devices linked")
    callback.setLeadingNavigationIconButton(LeadingNavigationIconButton(R.drawable.ic_dig_close_line) {})
    callback.setTopBarActions(listOf())
    callback.enableSheetGestures()
    callback.setBottomSheet { BottomSheet() }


    val benefits = getBenefits()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = MaterialTheme.colors.secondary),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            item {
                Image(
                    painter = painterResource(id = R.drawable.devices_room),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(min = 250.dp, max = 320.dp)
                        .padding(0.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter
                )
            }

            item {
                Surface(
                    modifier = Modifier
                        .fillMaxWidth(), color = MaterialTheme.colors.background, elevation = 12.dp
                ) {

                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = stringResource(id = R.string.device_limits_title),
                            style = MaterialTheme.typography.h4,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )

                        benefits.forEach { benefit ->
                            benefit.Inflate()
                        }
                    }
                }

            }
        }






        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp), color = MaterialTheme.colors.background
        ) {

            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                    shape = RectangleShape
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Try free for 30 days",
                            color = MaterialTheme.colors.onPrimary,
                            style = MaterialTheme.typography.button,
                            fontWeight = FontWeight.Bold
                        )
                    }

                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp)
                        .clickable {
                            callback.expandBottomSheet()
                        },
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "Subscription details",
                        color = MaterialTheme.colors.faintText,
                        style = MaterialTheme.typography.button,
                        fontWeight = FontWeight.Normal,
                        modifier = Modifier.padding(end = 8.dp)
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.chevron_up),
                        modifier = Modifier.size(16.dp),
                        tint = MaterialTheme.colors.primary,
                        contentDescription = null
                    )
                }
            }
        }
    }
}


@Composable
private fun BottomSheet() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .padding(16.dp)
    ) {


        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Subscription details",
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(end = 16.dp)
            )

            Icon(
                painter = painterResource(id = R.drawable.chevron_down),
                contentDescription = null,
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colors.primary
            )
        }


        Text(
            text = "This subscription automatically renews after the 30-day free trial. You can turn off auto-renew at least 24 hours before your billing period ends.\n" +
                "\n" +
                "By upgrading your account, you agree to Dropbox’sTerms of Service and Privacy Policy."
        )
    }
}


data class BenefitIcon(
    @DrawableRes val res: Int,
    val tint: Color
)

data class BenefitText(
    @StringRes val res: Int,
    val style: TextStyle,
    val fontWeight: FontWeight
)

data class Benefit(
    val icon: BenefitIcon,
    val text: BenefitText
)

@Composable
fun Benefit.Inflate() {
    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(id = icon.res),
            contentDescription = null,
            tint = icon.tint,
            modifier = Modifier
                .size(32.dp)
                .padding(end = 16.dp)
        )

        Text(text = stringResource(id = text.res), style = text.style, fontWeight = text.fontWeight)
    }
}