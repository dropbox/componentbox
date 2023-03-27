# Component Box

## Data Structures

### [Graph](src/commonMain/kotlin/com/dropbox/componentbox/Graph.kt)

A collection of forests and trails. It represents the navigation hierarchy for an application.

### [Forest](src/commonMain/kotlin/com/dropbox/componentbox/Forest.kt)

A set of trees. It represents a hybrid module or feature in the
application. For example, a screen with some of its UI components driven by Component Box.

### [Trail](src/commonMain/kotlin/com/dropbox/componentbox/Trail.kt)

A sequence of trees. It represents the connection of root components. For example, a
login or onboarding flow.

### [Tree](src/commonMain/kotlin/com/dropbox/componentbox/Tree.kt)

A root component container. It represents the hierarchical structure of UI components. For
example, a screen.

## Components

### AnnotatedString

```kotlin
val annotatedString = annotatedString()

annotatedString.text("Component", TextStyle(fontSize = 24.sp))
annotatedString.text(" ")
annotatedString.text("Box")
annotatedString.span(0, 5, SpanStyle(fontWeight = FontWeight.Bold))
annotatedString.span(6, 12, SpanStyle(textDecoration = TextDecoration.Underline))
```

### Box

```kotlin
val box = box {
    child(heading)
    child(button)
}

```

### Column

```kotlin
val column = column(
    verticalArrangement = Arrangement.SpaceBetween(4.dp),
    horizontalAlignment = Alignment.Center
) {
    child(heading)
    child(button)
}

```

### ContainedButton

```kotlin
val containedButton = containedButton(
    onClick = {},
    backgroundColor = Color.named("Primary"),
    contentColor = Color.named("OnPrimary"),
    elevation = 0.dp,
    shape = Shape.Rectangle
) {
    child(text("Learn more"))
}
```

### LazyColumn

```kotlin
val lazyColumn = lazyColumn {
    child(heading)
    child(button)
}

```

### Navigation

```kotlin
val navigation = navigation(start = "account_tab") {
    route("account_tab", accountTab)
    route("manage_account_screen", manageAccountScreen)
}
```

### Text

```kotlin
val text = text("Component Box", Color.RED, TextStyle.BOLD)
```

### TextButton

```kotlin
val textButton = textButton(text = "Learn more")
```