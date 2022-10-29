package com.dropbox.componentbox.campaigns.android.feature.account.ui.wiring

import com.dropbox.componentbox.campaigns.android.common.binding.DaggerMavericksBindings
import com.dropbox.componentbox.campaigns.android.common.scoping.AccountScope
import com.dropbox.componentbox.campaigns.android.common.scoping.SingleIn
import com.dropbox.componentbox.campaigns.android.common.scoping.UserScope
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Subcomponent

@SingleIn(AccountScope::class)
@MergeSubcomponent(AccountScope::class)
interface AccountComponent : DaggerMavericksBindings {
    @Subcomponent.Builder
    interface Builder {
        fun build(): AccountComponent
    }

    @ContributesTo(UserScope::class)
    interface ParentBindings {
        fun accountComponentBuilder(): Builder
    }
}