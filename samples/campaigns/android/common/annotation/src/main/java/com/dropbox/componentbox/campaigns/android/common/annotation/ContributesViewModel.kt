package com.dropbox.componentbox.campaigns.android.common.annotation

import kotlin.reflect.KClass

@Target(AnnotationTarget.CLASS)
annotation class ContributesViewModel(
    val scope: KClass<*>,
)