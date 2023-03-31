package com.dropbox.componentbox

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
sealed interface ComponentBox

typealias ComponentBoxId = String
typealias GraphId = String
typealias ForestId = String
typealias TreeId = String

fun <T : ComponentBox> graph(
    start: ComponentBoxId,
    builder: Graph.Static.() -> Unit
): Graph.Static =
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
fun Graph(start: ComponentBoxId, builder: @Composable Graph.Dynamic.() -> Unit) =
    DynamicGraph(start)

@Composable
fun Trail(builder: @Composable Trail.Dynamic.() -> Unit) = DynamicTrail()

fun trail(builder: Trail.Static.() -> Unit) = Trail.Static()