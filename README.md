<img src="https://user-images.githubusercontent.com/59468153/226168774-5c086794-652b-4bf9-bc67-f1dc4b86d81f.svg" alt="componentbox" width=220/>

# Component Box

**🚧 Under development!**

**[componentbox.io](https://www.componentbox.io)**

### Sample

#### Model (server)

```kotlin
class Counter : ComposableModel<Int, CounterEvent>(0) {
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

    override fun on(event: CounterEvent) = when (event) {
        Increment -> increment()
        Decrement -> decrement()
    }
}
```

#### UI Representation (server)

##### Static

###### Screen

```kotlin
@SerializableComponentBox
fun homeScreen() = componentBox {
        tree {
            lazyColumn<CounterEvent>(
                verticalArrangement = Arrangement.SpaceEvenly(2.dp),
                horizontalAlignment = Alignment.Start
            ) {
                child(header)
                child(count)
                child(incrementButton)
                child(decrementButton)
            }
        }
    }

val header = text(
    text = "Component Box Counter",
    style = TextStyle(fontWeight = FontWeight.ExtraBold)
)

val count = text(
    text = "Count: \${COUNTER_STATE}",
    style = TextStyle(color = Color.Hex("#FF0000"))
)

val incrementButton = textButton(
    text = "+1",
    onClick = semantic { Increment }
)

val decrementButton = textButton(
    text = "-1",
    onClick = semantic { Decrement }
)
```

##### Dynamic

###### Graph

```kotlin
@Composable
@ComponentBoxExport
fun graph() = statefulComponentBoxGraph(init = null) {
        Graph(start = CounterOnboardingFlow.value) {
            componentBox(CounterLoginScreen.value, loginScreen())
            componentBox(CounterOnboardingFlow.value, onboardingFlow())
            componentBox(CounterScreen.Home.value, homeScreen())
        }
    }
```

###### Trail

```kotlin
@Composable
@ComponentBoxExport
fun statefulOnboardingFlow() = statefulComponentBox<Trail.Dynamic?>(init = null) {
        Trail {
            node(welcomeScreen())
            node(featureDiscoveryScreen())
            node(homeScreen())
        }
    } 
```

###### Screen

```kotlin
@Composable
@ComponentBoxExport
fun homeScreen() = statefulComponentBox(init = static) {
        ComponentBox {
            Tree {
                LazyColumn(
                    verticalArrangement = Arrangement.SpaceEvenly(2.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    child(header)
                    child(Count())
                    child(IncrementButton())
                    child(DecrementButton())
                }
            }
        }
    }

@Composable
fun IncrementButton() = StatefulComposable<Counter> {
    ContainedButton(onClick = lambda { it.on(Increment) }) {
        text(text = "+1")
    }
}

@Composable
fun DecrementButton() = StatefulComposable<Counter> {
    ContainedButton(onClick = lambda { it.on(Decrement) }) {
        text(text = "-1")
    }
}

@Composable
fun Count() = StatefulComposable<Counter> {
    text(
        text = "Count: ${it.state.value}",
        style = TextStyle(color = Color.Hex("#FF0000"))
    )
}


```

#### Binaries (server)

```shell
./gradlew componentBoxJs
```

```shell
./gradlew componentBoxWasm
```

```shell
./gradlew componentBoxJson
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
