package com.dropbox.componentbox.samples.campaigns.android.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import com.dropbox.componentbox.samples.campaigns.android.feature.account.AccountTab

class CampaignsMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            Column {
                Text(text = "Component Box")

                AccountTab()
            }
        }
    }
}