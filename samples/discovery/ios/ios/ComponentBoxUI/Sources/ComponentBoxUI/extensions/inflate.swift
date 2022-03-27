//
// Created by Matt Ramotar on 3/27/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//


import Foundation
import SwiftUI
import componentbox

@available(iOS 14.0, *)
public extension Component {
    @ViewBuilder func inflate() -> some View {
        switch self {
        case let button as Component.Button:
            let ui = ComponentBoxUI.Button(id: button.id, components: button.components as! [Component], modifier: button.modifier, isEnabled: button.isEnabled as! Bool, action: button.action, variant: button.variant)
            return AnyView(ui.inflate())
            
        case let text as Component.Text:
            let ui = ComponentBoxUI.Text(id: text.id, modifier: text.modifier, text: text.text, color: text.color, textStyle: text.textStyle)
            return AnyView(ui.inflate())
            
        default:
            return AnyView(HStack { })
        }
    }
}
