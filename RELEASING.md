# Releasing

1. Change the version in `gradle.properties` to a non-SNAPSHOT version
2. Update the `CHANGELOG.md`
3. `git commit -am "Prepare for release X.Y.Z"`
4. `git tag -a vX.Y.Z -m "Version X.Y.Z"`
5. `git push && git push --tags` to trigger CI to deploy the release
7. Update `gradle.properties` to next SNAPSHOT version
8. `git commit -am "Prepare next development version"`
9. `git push && git push --tags`