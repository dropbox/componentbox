// swift-tools-version:5.3
import PackageDescription

let remoteKotlinUrl = "https://api.github.com/repos/dropbox/componentbox/releases/assets/86646703.zip"
let remoteKotlinChecksum = "2d49ed0b97550502133af431da5424fc3206bcb44799b857d007255d9cb72943"
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