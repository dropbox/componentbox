//
// Created by Matt Ramotar on 3/18/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//

import Foundation
import SwiftUI

@available(iOS 14.0, *)
struct Scaffold: View {

    @State private var selectedTab = 0
    @Environment(\.colorScheme) var colorScheme

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

    init() {
        UITabBar.appearance().barTintColor = .systemBackground
        UITabBar.appearance().unselectedItemTintColor = UIColor(named: "OnBackground")
        UITabBar.appearance().tintColor = UIColor(named: "OnBackground")
        UINavigationBar.appearance().largeTitleTextAttributes = [.font: UIFont(name: "SharpGroteskDBCyrBook20", size: 28)!]
    }


    var body: some View {
        TabView(selection: handler) {
            HomeScreen().tabItem {
                        if (selectedTab == 0) {
                            Image("Home.Fill").renderingMode(.template)
                        } else {
                            Image("Home.Line").renderingMode(.template)
                        }

                        Text("Home")
                    }
                    .tag(0)


            FilesScreen().tabItem {
                        if (selectedTab == 1) {
                            Image("Folder.Fill").renderingMode(.template)
                        } else {
                            Image("Folder.Line").renderingMode(.template)
                        }

                        Text("Files")
                    }
                    .tag(1)

            PhotosScreen().tabItem {
                        if (selectedTab == 2) {
                            Image("Image.Fill").renderingMode(.template)
                        } else {
                            Image("Image.Line").renderingMode(.template)
                        }

                        Text("Photos")
                    }
                    .tag(2)

            PlansScreen().tabItem {
                        if (selectedTab == 3) {
                            Image("Upgrade.Line").renderingMode(.template)
                        } else {
                            Image("Upgrade.Line").renderingMode(.template)
                        }

                        Text("Plans")
                    }
                    .tag(3)

            AccountScreen().tabItem {
                        if (selectedTab == 4) {
                            Image("Person.Fill").renderingMode(.template)
                        } else {
                            Image("Person.Line").renderingMode(.template)
                        }

                        Text("Account")
                    }
                    .tag(4)
        }
                .accentColor(colorScheme == .dark ? Color.white : Color.black)
    }
}