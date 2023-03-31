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

###### [Tree](componentbox/src/commonMain/kotlin/com/dropbox/componentbox/Tree.kt)

```kotlin
@SerializableComponentBox
fun main() = componentBox {
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

###### [Graph](componentbox/src/commonMain/kotlin/com/dropbox/componentbox/Graph.kt)

```kotlin
@Composable
@ComponentBoxExport
fun main() = statefulComponentBoxGraph(init = null) {
        Graph(start = CounterOnboardingFlow.value) {
            componentBox(CounterLoginScreen.value, LoginScreen())
            componentBox(CounterOnboardingFlow.value, OnboardingFlow())
            componentBox(CounterScreen.Home.value, HomeScreen())
        }
    }
```

###### [Forest](componentbox/src/commonMain/kotlin/com/dropbox/componentbox/Forest.kt)

```kotlin
@Composable
fun LoginScreen() = Forest {
        tree("heading", Tree { LoginHeading() })
        tree("button", Tree { LoginButton() })
    }
```

###### [Trail](componentbox/src/commonMain/kotlin/com/dropbox/componentbox/Trail.kt)

```kotlin
@Composable
fun OnboardingFlow() = Trail {
        node(WelcomeScreen())
        node(FeatureDiscoveryScreen())
        node(HomeScreen())
    }
```

###### [Tree](componentbox/src/commonMain/kotlin/com/dropbox/componentbox/Tree.kt)

```kotlin
@Composable
fun HomeScreen() = ComponentBox {
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

## Acknowledgments

Thanks to our friends at [Cash App](http://github.com/cashapp)
  for [Zipline](http://github.com/cashapp/zipline)
