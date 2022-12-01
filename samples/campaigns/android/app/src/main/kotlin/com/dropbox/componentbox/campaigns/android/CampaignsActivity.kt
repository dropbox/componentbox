package com.dropbox.componentbox.campaigns.android

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dropbox.componentbox.campaigns.android.feature.account.ui.AccountFragment

class CampaignsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.campaigns_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.campaigns_activity, AccountFragment())
                .commitNow()
        }
    }
}