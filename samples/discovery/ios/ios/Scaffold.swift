//
// Created by Matt Ramotar on 3/18/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//

import Foundation
import SwiftUI

@available(iOS 14.0, *)
struct Scaffold: View {

    @State private var selectedTab = 0

    var handler: Binding<Int> {
        Binding(
                get: { selectedTab },
                set: {
                    if ($0 != selectedTab) {
                        selectedTab = $0
                    }
                }
        )
    }


    var body: some View {
        TabView(selection: handler) {
            HomeScreen().tabItem {
                        if (selectedTab == 0) {
                            Image("Home.Fill")
                        } else {
                            Image("Home.Line")
                        }

                        Text("Home")
                    }
                    .tag(0)


            FilesScreen().tabItem {
                        if (selectedTab == 1) {
                            Image("Folder.Fill")
                        } else {
                            Image("Folder.Line")
                        }

                        Text("Files")
                    }
                    .tag(1)

            PhotosScreen().tabItem {
                        if (selectedTab == 2) {
                            Image("Image.Fill")
                        } else {
                            Image("Image.Line")
                        }

                        Text("Photos")
                    }
                    .tag(2)

            PlansScreen().tabItem {
                        if (selectedTab == 3) {
                            Image("Upgrade.Line")
                        } else {
                            Image("Upgrade.Line")
                        }

                        Text("Plans")
                    }
                    .tag(3)

            AccountScreen().tabItem {
                        if (selectedTab == 4) {
                            Image("Person.Fill")
                        } else {
                            Image("Person.Line")
                        }

                        Text("Account")
                    }
                    .tag(4)
        }
                .accentColor(Color.black)
    }
}