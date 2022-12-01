package com.dropbox.componentbox.campaigns.android.feature.account.ui.wiring

import com.dropbox.componentbox.campaigns.android.common.scoping.AccountScope
import com.dropbox.componentbox.campaigns.android.common.scoping.SingleIn
import com.dropbox.componentbox.campaigns.android.common.scoping.UserScope
import com.squareup.anvil.annotations.ContributesSubcomponent
import com.squareup.anvil.annotations.ContributesTo

@SingleIn(AccountScope::class)
@ContributesSubcomponent(scope = AccountScope::class, parentScope = UserScope::class)
interface AccountComponent {
    @ContributesSubcomponent.Factory
    interface Factory {
        fun build(): AccountComponent
    }

    @ContributesTo(UserScope::class)
    interface ParentBindings {
        fun accountComponentBuilder(): Factory
    }
}