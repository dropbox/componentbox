<img src="https://user-images.githubusercontent.com/59468153/226168774-5c086794-652b-4bf9-bc67-f1dc4b86d81f.svg" alt="componentbox" width=220/>

# Component Box

**🚧 Under development!**

**[componentbox.io](https://www.componentbox.io)**

### Sample

#### Server

##### Model

```kotlin
class Counter : ComposableModel<Int, String>(0) {
    private fun increment() {
        withState {
            setState(state.value + 1)
        }
    }

    private fun decrement() {
        withState {
            setState(state.value - 1)
        }
    }

    override fun on(event: String) = when (event) {
        "increment" -> increment()
        "decrement" -> decrement()
        else -> {}
    }
}
```

##### UI

```kotlin
@ComponentBox
class Tree : Tree {
    private val counter = Counter()

    private val header = text(
            text = "Component Box Counter",
            style = TextStyle(fontWeight = FontWeight.ExtraBold)
    )

    private val count = text(
            text = "Count: ${counter.state.value}",
            style = TextStyle(color = Color.Hex("#FF0000"))
    )

    private val incrementButton = textButton(text = "+1") { counter.on("increment") }
    private val decrementButton = textButton(text = "-1") { counter.on("decrement") }

    override val root: Component = column(
            verticalArrangement = Arrangement.SpaceEvenly(2.dp),
            horizontalAlignment = Alignment.Start
    ) {
        child(header)
        child(count)
        child(incrementButton)
        child(decrementButton)
    }
}
```

##### Config

```json
[
  {
    "file": "src/commonMain/kotlin/com/dropbox/componentbox/samples/counter/Tree.kt",
    "tree": "com.dropbox.componentbox.samples.counter.Tree"
  }
]
```

#### Binaries

```shell
./gradlew componentBoxJs --configFile=/path/to/input/file
```

```shell
./gradlew componentBoxWasm --configFile=/path/to/input/file
```

```shell
./gradlew componentBoxJson --configFile=/path/to/input/file
```

## Snapshots

Snapshots are available
in [Sonatype's snapshots repository](https://s01.oss.sonatype.org/content/repositories/snapshots/com/dropbox/componentbox/).

## License

```text
Copyright (c) 2023 Dropbox, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
