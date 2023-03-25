## Zipline

`ComponentBoxService` wraps `Zipline` to load and manage a Component Box.

- It sets up a single-threaded executor service for Zipline and a corresponding coroutine
  dispatcher.
- The `launch` function takes a `manifestUrl` and starts the process of downloading, caching, and
  loading the `Kotlin/JS` code using `ZiplineLoader`.
- The loaded Component Box is stored in a mutable state flow called `stateFlow`, which allows
  observing and reacting to state changes of the loaded component.
- The close function shuts down the executor service, effectively stopping `Zipline`.

### Usage

1. To use `ComponentBoxService` in your project, create an instance of it, passing
   a `CoroutineScope`:

```kotlin
val componentBoxService = ComponentBoxService(scope = CoroutineScope(Dispatchers.Main))
```

2. Then, call the launch function with a manifest URL:

```kotlin
componentBoxService.launch("http://localhost:8080/manifest.zipline.json")
```

3. You can observe the state of the loaded Component Box using the `componentBox` property:

```kotlin
val componentBox = componentBoxService.componentBox.collectAsState()
```

4. Finally, don't forget to call the close function when you're done using the ComponentBoxService:

```kotlin
componentBoxService.close()
```