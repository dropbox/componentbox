//
// Created by Matt Ramotar on 3/27/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//


import Foundation
import SwiftUI
import componentbox

enum ComponentBoxUI {
    case Box(
        id: String,
        components: [componentbox.Component]?,
        modifier: componentbox.Modifier?,
        horizontalArrangement: componentbox.Arrangement?,
        verticalAlignment: componentbox.Alignment?,
        action: String?
    )
    
    case Button(id: String, components: [componentbox.Component]?, modifier: componentbox.Modifier?, isEnabled: Bool?, action: String?, variant: String?)
    
    case Column(
        id: String,
        components: [componentbox.Component]?,
        modifier: componentbox.Modifier?,
        verticalArrangement: componentbox.Arrangement?,
        horizontalAlignment: componentbox.Alignment?,
        action: String?,
        isLazy: Bool?
    )
    
    case Image(
        id: String,
        name: String?,
        url: String?,
        contentDescription: String?,
        modifier: componentbox.Modifier?,
        alignment: componentbox.Alignment?,
        contentScale: componentbox.ContentScale?
    )
    
    case Icon(
        id: String,
        name: String?,
        modifier: componentbox.Modifier?,
        alignment: componentbox.Alignment?,
        contentScale: componentbox.ContentScale?,
        color: componentbox.Color?
    )
    
    case Row(
        id: String,
        components: [componentbox.Component]?,
        modifier: componentbox.Modifier?,
        horizontalArrangement: componentbox.Arrangement?,
        verticalAlignment: componentbox.Alignment?,
        action: String?,
        isLazy: Bool?
    )
    
    case Text(id: String, modifier: componentbox.Modifier?, text: String?, color: componentbox.Color?, textStyle: String?)
    
    @available(iOS 14.0, *)
    func inflate() -> some View {
        switch self {
            
        case let .Box(id, components, modifier, horizontalArrangement, verticalAlignment, action):
            return AnyView(ComponentBoxUIBox(id: id, components: components, modifier: modifier, horizontalArrangement: horizontalArrangement, verticalAlignment: verticalAlignment, action: action))
        
        case let .Button(id, components, modifier, isEnabled, action, variant):
            return AnyView(ComponentBoxUIButton(id: id, components: components, modifier: modifier, isEnabled: isEnabled, action: action, variant: variant))
            
        case let .Column(id, components, modifier, verticalArrangement, horizontalAlignment, action, isLazy):
            return AnyView(ComponentBoxUIColumn(id: id, components: components, modifier: modifier, verticalArrangement: verticalArrangement, horizontalAlignment: horizontalAlignment, action: action, isLazy: isLazy))
            
        case let .Image(id, name, url, contentDescription, modifier, alignment, contentScale):
            return AnyView(ComponentBoxUIImage(id: id, name: name, url: url, contentDescription: contentDescription, modifier: modifier, alignment: alignment, contentScale: contentScale))
            
        case let .Icon(id, name, modifier, alignment, contentScale, color):
            return AnyView(ComponentBoxUIIcon(id: id, name: name, modifier: modifier, alignment: alignment, contentScale: contentScale, color: color))
            
        case let .Row(id, components, modifier, horizontalArrangement, verticalAlignment, action, isLazy):
            return AnyView(ComponentBoxUIRow(id: id, components: components, modifier: modifier, horizontalArrangement: horizontalArrangement, verticalAlignment: verticalAlignment, action: action, isLazy: isLazy))
        
        case let .Text(id, modifier, text, color, textStyle):
            return AnyView(ComponentBoxUIText(id: id, modifier: modifier, text: text, color: color, textStyle: textStyle))
        }
    }
}
