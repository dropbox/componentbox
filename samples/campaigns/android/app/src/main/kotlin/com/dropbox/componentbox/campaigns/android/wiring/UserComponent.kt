package com.dropbox.componentbox.campaigns.android.wiring

import com.dropbox.componentbox.campaigns.android.common.scoping.AppScope
import com.dropbox.componentbox.campaigns.android.common.scoping.SingleIn
import com.dropbox.componentbox.campaigns.android.common.scoping.UserScope
import com.dropbox.componentbox.campaigns.android.common.user.CampaignsUser
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.BindsInstance
import dagger.Subcomponent


@SingleIn(UserScope::class)
@MergeSubcomponent(UserScope::class)
interface UserComponent {
    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun user(user: CampaignsUser): Builder
        fun build(): UserComponent
    }

    @ContributesTo(AppScope::class)
    interface ParentBindings {
        fun userComponentBuilder(): Builder
    }
}