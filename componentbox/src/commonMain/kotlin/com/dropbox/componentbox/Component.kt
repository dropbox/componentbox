package com.dropbox.componentbox

import androidx.compose.runtime.Composable
import kotlinx.serialization.Serializable

@Serializable
sealed interface Component

fun annotatedString(
    elements: MutableList<AnnotatedStringElement> = mutableListOf()
): Component = AnnotatedString(elements)

fun <Event : Any> box(
    modifier: Modifier = Modifier(),
    events: Events.Semantic<Event>? = null,
    children: Box.() -> Unit
): Component = Box.Static(modifier, events)

@Composable
fun Box(
    modifier: Modifier = Modifier(),
    events: Events.Lambda? = null,
    children: @Composable Box.() -> Unit
): Component = Box.Dynamic(modifier, events)

fun <Event : Any> column(
    modifier: Modifier = Modifier(),
    events: Events.Semantic<Event>? = null,
    verticalArrangement: Arrangement.Vertical? = null,
    horizontalAlignment: Alignment.Horizontal? = null,
    children: Column.Static<Event>.() -> Unit
): Component = Column.Static(modifier, events, verticalArrangement, horizontalAlignment)

@Composable
fun Column(
    modifier: Modifier = Modifier(),
    events: Events.Lambda? = null,
    verticalArrangement: Arrangement.Vertical? = null,
    horizontalAlignment: Alignment.Horizontal? = null,
    children: @Composable Column.Dynamic.() -> Unit
): Component = Column.Dynamic(modifier, events, verticalArrangement, horizontalAlignment)


fun <Event : Any> containedButton(
    modifier: Modifier = Modifier(),
    enabled: Boolean = true,
    onClick: Action.Semantic<Event>? = null,
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    elevation: Dp? = null,
    shape: Shape,
    children: Button.Contained.Static<Event>.() -> Unit
): Component = Button.Contained.Static(
    modifier,
    enabled,
    onClick,
    backgroundColor,
    contentColor,
    elevation,
    shape
)


@Composable
fun ContainedButton(
    modifier: Modifier = Modifier(),
    enabled: Boolean = true,
    onClick: Action.Lambda? = null,
    backgroundColor: Color? = null,
    contentColor: Color? = null,
    elevation: Dp? = null,
    shape: Shape? = null,
    children: @Composable Button.Contained.Dynamic.() -> Unit
): Component = Button.Contained.Dynamic(
    modifier,
    enabled,
    onClick,
    backgroundColor,
    contentColor,
    elevation,
    shape
)

@Composable
fun LazyColumn(
    modifier: Modifier = Modifier(),
    events: Events.Lambda? = null,
    verticalArrangement: Arrangement.Vertical? = null,
    horizontalAlignment: Alignment.Horizontal? = null,
    contentPaddingValues: PaddingValues? = null,
    children: @Composable LazyColumn.Dynamic.() -> Unit
): Component = LazyColumn.Dynamic(
    modifier,
    events,
    verticalArrangement,
    horizontalAlignment,
    contentPaddingValues
)


fun <Event : Any> lazyColumn(
    modifier: Modifier = Modifier(),
    events: Events.Semantic<Event>? = null,
    verticalArrangement: Arrangement.Vertical? = null,
    horizontalAlignment: Alignment.Horizontal? = null,
    contentPaddingValues: PaddingValues? = null,
    children: LazyColumn.Static<Event>.() -> Unit
): Component = LazyColumn.Static(
    modifier,
    events,
    verticalArrangement,
    horizontalAlignment,
    contentPaddingValues
)


fun <Route : Any> navigation(
    routes: Routes<Route> = mutableMapOf(),
    start: String,
    routing: Trail<Route>.() -> Unit
): Forest = Trail(routes, start)

fun text(
    text: String,
    color: Color? = null,
    style: TextStyle? = null
): Component = Text(text, color, style)


fun <Event : Any> textButton(
    modifier: Modifier = Modifier(),
    text: String,
    contentColor: Color? = null,
    enabled: Boolean = false,
    onClick: Action.Semantic<Event>? = null,
): Component = Button.Text.Static(modifier, text, contentColor, enabled, onClick)

@Composable
fun TextButton(
    modifier: Modifier = Modifier(),
    text: String,
    contentColor: Color? = null,
    enabled: Boolean = false,
    onClick: Action.Lambda? = null,
): Component = Button.Text.Dynamic(modifier, text, contentColor, enabled, onClick)


@Composable
fun Tree(root: @Composable () -> Component): Tree = Tree.Dynamic(root())

fun tree(root: () -> Component): Tree = Tree.Static(root())

@Composable
fun Forest(start: TreeId, trees: @Composable Forest.() -> Unit): Forest.Dynamic =
    Forest.Dynamic(start)

fun forest(start: TreeId, trees: Forest.() -> Unit): Forest.Static = Forest.Static(start)