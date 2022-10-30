package com.dropbox.componentbox.campaigns.android.wiring

import com.dropbox.componentbox.campaigns.android.common.scoping.AppScope
import com.dropbox.componentbox.campaigns.android.common.scoping.SingleIn
import com.squareup.anvil.annotations.MergeComponent

@SingleIn(AppScope::class)
@MergeComponent(AppScope::class)
interface AppComponent