//
// Created by Matt Ramotar on 3/18/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//

import Foundation
import SwiftUI
import componentbox

@available(iOS 14.0, *)
struct PlansScreen: View {
    
    @State private var viewModel = PlansScreenViewModel()
    
    var body: some View {
        NavigationView {
            Content(screen: viewModel.screen)
                .navigationTitle(viewModel.screen?.title ?? "Plans")
                    .toolbar {
                        ToolbarItem(placement: ToolbarItemPlacement.navigationBarLeading) {
                            Image("Notification.Line").resizable().frame(width: 32.0, height: 32.0)
                        }
                    }
        }
    }


}

@available(iOS 14.0, *)
private struct Content: View {
    
    let screen: ComponentBox.Screen?
    
    var body: some View {
        VStack {
            ComponentBoxScreenView(id: UUID().uuidString , title: screen?.title, verticalArrangement: screen?.verticalArrangement, horizontalAlignment: screen?.horizontalAlignment, components: screen?.components as [Component]?)
        }
                .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: Alignment.top).padding()
    }
}
