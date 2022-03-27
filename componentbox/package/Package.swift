// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "ComponentBox",
    platforms: [
        .iOS(.v14)
    ],
    products: [
        .library(
            name: "ComponentBox",
            targets: ["ComponentBox"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "ComponentBox",
            path: "./ComponentBox.xcframework"
        ),
    ]
)
