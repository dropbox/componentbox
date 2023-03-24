package com.dropbox.componentbox

import kotlin.reflect.KClass

@Retention(AnnotationRetention.SOURCE)
@Target(AnnotationTarget.CLASS)
annotation class ComponentBox(val tree: KClass<out Any> = Tree::class)