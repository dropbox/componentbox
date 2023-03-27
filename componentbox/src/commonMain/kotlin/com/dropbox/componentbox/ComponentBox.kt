package com.dropbox.componentbox

import androidx.compose.runtime.Composable


sealed interface ComponentBox

typealias GraphId = String
typealias ForestId = String
typealias TreeId = String

fun graph(start: ForestId, builder: Graph.Static.() -> Unit): Graph.Static =
    StaticGraph(start)

fun componentBox(builder: Forest.Static.() -> Unit): Forest.Static =
    Forest.Static()

fun tree(root: () -> Component): Tree.Static = Tree.Static(root())

@Composable
fun Tree(root: @Composable () -> Component): Tree.Dynamic = Tree.Dynamic(root())

@Composable
fun Forest(trees: @Composable Forest.Dynamic.() -> Unit): Forest.Dynamic =
    DynamicForest()

fun forest(trees: Forest.Static.() -> Unit): Forest.Static = Forest.Static()

@Composable
fun ComponentBox(root: @Composable () -> Component): Tree.Dynamic = Tree.Dynamic(root())

@Composable
fun ComponentBox(builder: @Composable Forest.Dynamic.() -> Unit) =
    DynamicForest()

@Composable
fun Graph(start: ForestId, builder: @Composable Graph.Dynamic.() -> Unit) =
    DynamicGraph(start)