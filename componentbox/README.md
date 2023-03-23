# Component Box

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