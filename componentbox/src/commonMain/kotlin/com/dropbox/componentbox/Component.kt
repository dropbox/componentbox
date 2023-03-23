package com.dropbox.componentbox

sealed interface Component

fun annotatedString(
    elements: MutableList<AnnotatedStringElement> = mutableListOf()
): Component = AnnotatedString(elements)

fun box(
    modifier: Modifier = Modifier(),
    events: Events? = null,
    children: Box.() -> Unit
): Component = Box(modifier, events)

fun column(
    modifier: Modifier = Modifier(),
    events: Events? = null,
    verticalArrangement: Arrangement.Vertical? = null,
    horizontalAlignment: Alignment.Horizontal? = null,
    children: Column.() -> Unit
): Component = Column(modifier, events, verticalArrangement, horizontalAlignment)

fun containedButton(
    modifier: Modifier = Modifier(),
    enabled: Boolean = false,
    onClick: (() -> Unit)? = null,
    backgroundColor: Color,
    contentColor: Color,
    elevation: Dp,
    shape: Shape,
    children: Button.() -> Unit
): Component = Button.Contained(modifier, enabled, onClick, backgroundColor, contentColor, elevation, shape)

fun lazyColumn(
    modifier: Modifier = Modifier(),
    events: Events? = null,
    verticalArrangement: Arrangement.Vertical? = null,
    horizontalAlignment: Alignment.Horizontal? = null,
    contentPaddingValues: PaddingValues? = null,
    children: LazyColumn.() -> Unit
): Component = LazyColumn(modifier, events, verticalArrangement, horizontalAlignment, contentPaddingValues)

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
