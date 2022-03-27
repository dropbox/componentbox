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
    
    func log() {
        print(components?.count ?? "NO components")
    }

    var body: some View {
        
        SwiftUI.Button(action: {}, label: {
            
            if (self.components != nil) {
                ForEach(self.components!, id: \.self) { component in
                    component.inflate()
            }
        }}).buttonStyle(PrimaryButton(fillMaxWidth: modifier?.fillMaxWidth as? Bool ?? false))
    }
}



@available(iOS 14.0, *)
struct PrimaryButton: ButtonStyle {
    
    let fillMaxWidth: Bool

    func makeBody(configuration: Self.Configuration) -> some View {
        configuration.label
                .padding(12)
                .frame(maxWidth: fillMaxWidth ? .infinity : .none)
                .foregroundColor(Color.ui.onPrimary)
                .font(.sharpGroteskBook(withStyle: .title3, size: 16))
                .background(Color.ui.primary)
    }
}
