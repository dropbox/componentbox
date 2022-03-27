//
// Created by Matt Ramotar on 3/27/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//


import Foundation
import SwiftUI
import componentbox

@available(iOS 14.0, *)
struct ComponentBoxUIButton: View, Identifiable {
    let id: String
    let components: [componentbox.Component]?
    let modifier: componentbox.Modifier?
    let isEnabled: Bool?
    let action: String?
    let variant: String?


    var body: some View {
        SwiftUI.Button {

        } label: {

            ForEach(self.components!, id: \.self) { component in
                component.inflate()

            }}.padding().frame(maxWidth: .infinity)
    }
}
