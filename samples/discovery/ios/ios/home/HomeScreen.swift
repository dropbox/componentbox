//
// Created by Matt Ramotar on 3/18/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//

import Foundation
import SwiftUI

@available(iOS 14.0, *)
struct HomeScreen: View {
    var body: some View {
        NavigationView {
            Content()
                    .navigationTitle("Home")
                    .toolbar {
                        ToolbarItem(placement: ToolbarItemPlacement.navigationBarLeading) {
                            Image("Notification.Line").resizable().frame(width: 32.0, height: 32.0)
                        }
                    }
        }
    }


}

private struct Content: View {
    var body: some View {
        VStack {

        }
                .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: Alignment.top).padding()
    }
}