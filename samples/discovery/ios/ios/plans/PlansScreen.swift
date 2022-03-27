//
// Created by Matt Ramotar on 3/18/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//

import Foundation
import SwiftUI
import componentbox
import ComponentBoxUI

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
    let button: Component = Component.Button(id: "1", components: [Component.Text(id: "2", modifier: nil, text: "Upgrade", color: nil, textStyle: nil)], modifier: nil, isEnabled: true, action: nil, variant: nil)
    
    var body: some View {
        VStack {
            button.inflate()
            Text(screen?.title ?? "No title")
            
        }
                .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: Alignment.top).padding()
    }
}
