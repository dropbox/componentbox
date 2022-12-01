// swift-tools-version:5.3
import PackageDescription

let remoteKotlinUrl = "https://api.github.com/repos/dropbox/componentbox/releases/assets/86645920.zip"
let remoteKotlinChecksum = "564a9003da4bf1aaf6bc4202733fe5de50f1f8cdefd9a738df918bd99da6c74c"
let packageName = "componentbox"

let package = Package(
    name: packageName,
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: packageName,
            targets: [packageName]
        ),
    ],
    targets: [
        .binaryTarget(
            name: packageName,
            url: remoteKotlinUrl,
            checksum: remoteKotlinChecksum
        )
        ,
    ]
)