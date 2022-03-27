//
// Created by Matt Ramotar on 3/27/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//


import Foundation
import SwiftUI
import componentbox

enum ComponentBoxUI {
    case Button(id: String, components: [componentbox.Component]?, modifier: componentbox.Modifier?, isEnabled: Bool?, action: String?, variant: String?)
    case Text(id: String, modifier: componentbox.Modifier?, text: String?, color: componentbox.Color?, textStyle: String?)
    
    @available(iOS 14.0, *)
    func inflate() -> some View {
        switch self {
        
        case let .Button(id, components, modifier, isEnabled, action, variant):
            return AnyView(ComponentBoxUIButton(id: id, components: components, modifier: modifier, isEnabled: isEnabled, action: action, variant: variant))
            
        case let .Text(id, modifier, text, color, textStyle):
            return AnyView(ComponentBoxUIText(id: id, modifier: modifier, text: text, color: color, textStyle: textStyle))
        }
    }
}





