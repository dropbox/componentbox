## Component Box Gradle Plugin

A Gradle plugin that generates JSON, JavaScript, and WebAssembly based on classes annotated
with `@ComponentBox`.

### Requirements

- Gradle 7.2+
- Kotlin 1.5+

### Getting Started

1. Add the following to your build.gradle file:

```groovy 
plugins {
    id 'com.dropbox.componentbox.plugin'
}
```

2. Annotate your Kotlin classes with `@ComponentBox`. For example:

```kotlin 
@ComponentBox
class Tree : Tree {
    override val root = column {}
}
```

3. Run the Gradle tasks to generate the components:

```bash
./gradlew componentBoxJson
./gradlew componentBoxJs
./gradlew componentBoxWasm
```

The components will be generated in the build/componentbox directory.

### Advanced Configuration

You can configure the Component Box plugin using the `componentBox` extension in your `build.gradle`
file. For example:

```groovy
componentBox {
    outputDir file("componentbox")
}
```

The following options are available:

- outputDir: The directory where the components will be generated. Default: build/componentbox.
- include: A list of regular expressions that matches the paths of the files to be scanned.
  Default: **/*.kt.
- exclude: A list of regular expressions that matches the paths of the files to be excluded from
  scanning. Default: null.
- json: Configuration for the JSON generator.
- js: Configuration for the JS generator.
- wasm: Configuration for the WASM generator.
