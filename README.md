<img src="https://user-images.githubusercontent.com/59468153/226168774-5c086794-652b-4bf9-bc67-f1dc4b86d81f.svg" alt="componentbox" width=220/>

# Component Box

**🚧 Under development!**

**[componentbox.io](https://www.componentbox.io)**

### Sample

#### Model (server)

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

#### UI Representation (server)

```kotlin
@Serializable()
@ComponentBox
class Tree : Tree {
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

#### .componentbox.json (server)

```json
{
  "file": "src/commonMain/kotlin/com/dropbox/componentbox/samples/counter/Tree.kt",
  "tree": "com.dropbox.componentbox.samples.counter.Tree"
}
```

#### Binaries (server)

```shell
./gradlew componentBoxJs --configFile=/path/to/config/file
```

```shell
./gradlew componentBoxWasm --configFile=/path/to/config/file
```

```shell
./gradlew componentBoxJson --configFile=/path/to/config/file
```

#### Jetpack Compose (Android)

##### Activity

```kotlin
class ComponentBoxActivity : ComponentActivity() {
    private val scope = CoroutineScope(Dispatchers.Default)
    private val service = ComponentBoxService(scope)
    private val componentBox = service.componentBox
    private val render = RenderingEngine()

    override fun onStart() {
        super.onStart()
        service.launch(MANIFEST_URL)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            val root = componentBox.collectAsState()
            render {
                root.value
            }
        }
    }
}
```

##### Composable

```kotlin
@Composable
fun ComponentBoxView(componentBox: StateFlow<Component?>, render: RenderingEngine) {
    val root = componentBox.collectAsState()
    render {
        root.value
    }
}
```

#### React (web)

```js
export default function ComponentBoxView(props: {manifestUrl: string}) {
  const [root, setRoot] = useState<Component | null>(null);
  const service = new ComponentBoxService();
  const render = new RenderingEngine();

  useEffect(() => {
    async function launch(manifestUrl: string): Tree {
        const componentBox = await service.launch(manifestUrl)
        setRoot(componentBox.root)
    }
    
    launch(props.manifestUrl)
 
  }, [props.manifestUrl]);
  
  return render(root)
}
```

#### SwiftUI (iOS)

```swift
struct ComponentBoxView: View {
    @StateObject private var service = ComponentBoxService()
    @State private var root: Component?
    
    var body: some View {
        render {
            root
        }
        .onAppear {
            service.launch(from: MANIFEST_URL) { result in
                switch result {
                case .success(let componentBox):
                    DispatchQueue.main.async {
                        self.root = componentBox.root
                    }
            }
        }
    }
}
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
