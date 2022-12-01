package com.dropbox.componentbox.campaigns.android

import android.app.Application
import com.airbnb.mvrx.Mavericks
import com.dropbox.componentbox.campaigns.android.common.binding.bindings
import com.dropbox.componentbox.campaigns.android.common.scoping.ComponentHolder
import com.dropbox.componentbox.campaigns.android.common.user.CampaignsUser
import com.dropbox.componentbox.campaigns.android.inject.RealCampaignsUser
import com.dropbox.componentbox.campaigns.android.wiring.AppComponent
import com.dropbox.componentbox.campaigns.android.wiring.DaggerAppComponent
import com.dropbox.componentbox.campaigns.android.wiring.UserComponent

class CampaignsApp : Application(), ComponentHolder {

    lateinit var appComponent: AppComponent
    var userComponent: UserComponent? = null

    override val component: Any
        get() = listOfNotNull(appComponent, userComponent)

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
        userComponent = bindings<UserComponent.ParentBindings>()
            .userComponentBuilder()
            .user(getUser())
            .build()

        Mavericks.initialize(this)
    }

    private fun getUser(): CampaignsUser {
        return RealCampaignsUser(
            id = "2fs0aa2lc89",
            name = "Tag Ramotar",
            email = "tag@dbx51.com"
        )
    }
}