package com.dropbox.componentbox

import kotlin.reflect.KClass

@MustBeDocumented
@Retention(AnnotationRetention.SOURCE)
@Target(allowedTargets = [AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.TYPE, AnnotationTarget.LOCAL_VARIABLE])
annotation class ComponentBox(val tree: KClass<out Any> = Tree::class)

