# Component Box

## Components

### AnnotatedString

```kotlin
val annotatedString = Component.annotatedString()

annotatedString.text("Component", TextStyle(fontSize = 24.sp))
annotatedString.text(" ")
annotatedString.text("Box!")
annotatedString.span(0, 5, SpanStyle(fontWeight = FontWeight.Bold))
annotatedString.span(6, 12, SpanStyle(textDecoration = TextDecoration.Underline))
```

### Box

```kotlin
val box = Component.box {
    child(button("Learn more"))
}

```

### Column

```kotlin
val column = Component.column(
    verticalArrangement = Arrangement.SpaceBetween(4.dp),
    horizontalAlignment = Alignment.Center
) {
    child(text("Component Box"))
    child(button("Learn more"))
}

```

### Text

```kotlin
val text = Component.text("Component Box!", Color.RED, TextStyle.BOLD)
```
