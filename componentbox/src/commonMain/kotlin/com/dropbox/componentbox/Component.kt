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

fun containedButton(
    modifier: Modifier = Modifier(),
    enabled: Boolean = true,
    onClick: (() -> Unit)? = null,
    backgroundColor: Color,
    contentColor: Color,
    elevation: Dp,
    shape: Shape,
    children: Button.Contained.() -> Unit
): Component =
    Button.Contained(modifier, enabled, onClick, backgroundColor, contentColor, elevation, shape)


fun lazyColumn(
    modifier: Modifier = Modifier(),
    events: Events? = null,
    verticalArrangement: Arrangement.Vertical? = null,
    horizontalAlignment: Alignment.Horizontal? = null,
    contentPaddingValues: PaddingValues? = null,
    children: LazyColumn.() -> Unit
): Component =
    LazyColumn(modifier, events, verticalArrangement, horizontalAlignment, contentPaddingValues)

fun navigation(
    routes: MutableMap<String, Component> = mutableMapOf(),
    start: String,
    routing: Navigation.() -> Unit
): Component = Navigation(routes, start)

fun text(
    text: String,
    color: Color? = null,
    style: TextStyle? = null
): Component = Text(text, color, style)

fun textButton(
    modifier: Modifier = Modifier(),
    text: String,
    contentColor: Color? = null,
    enabled: Boolean = false,
    onClick: (() -> Unit)? = null,
): Component = Button.Text(modifier, text, contentColor, enabled, onClick)


@Composable
fun Tree(root: @Composable () -> Component): Tree = Tree(root())

fun tree(root: () -> Component): Tree = Tree(root())