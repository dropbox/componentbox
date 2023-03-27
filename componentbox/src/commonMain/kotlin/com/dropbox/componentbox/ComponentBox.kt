package com.dropbox.componentbox

import androidx.compose.runtime.Composable


sealed interface ComponentBox

typealias GraphId = String
typealias ForestId = String
typealias TreeId = String

fun componentBox(start: ForestId, builder: Graph.Static.() -> Unit): Graph.Static =
    StaticGraph(start)

fun componentBox(start: TreeId, builder: Forest.Static.() -> Unit): Forest.Static =
    Forest.Static(start)

fun componentBox(root: () -> Component): Tree.Static = Tree.Static(root())

@Composable
fun ComponentBox(root: @Composable () -> Component): Tree.Dynamic = Tree.Dynamic(root())

@Composable
fun ComponentBox(start: TreeId, builder: @Composable Forest.Dynamic.() -> Unit) =
    Forest.Dynamic(start)

@Composable
fun ComponentBox(start: ForestId, builder: @Composable Graph.Dynamic.() -> Unit) =
    DynamicGraph(start)