//
// Created by Matt Ramotar on 3/27/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//


import Foundation
import SwiftUI
import componentbox

@available(iOS 14.0, *)
public extension Component {
    func inflate() -> some View {
        switch self {
            
        case let box as Component.Box:
            let ui = ComponentBoxUI.Box(
                id: box.id,
                components: box.components as? [componentbox.Component],
                modifier: box.modifier,
                horizontalArrangement: box.horizontalArrangement,
                verticalAlignment: box.verticalAlignment,
                action: box.action
            )
            
            return AnyView(ui.inflate())
            
        case let button as Component.Button:
            let ui = ComponentBoxUI.Button(id: button.id, components: button.components as? [componentbox.Component], modifier: button.modifier, isEnabled: button.isEnabled as? Bool, action: button.action, variant: button.variant)
            return AnyView(ui.inflate())
            
        case let column as Component.Column:
            let ui = ComponentBoxUI.Column(
                id: column.id,
                components: column.components as? [componentbox.Component],
                modifier: column.modifier,
                verticalArrangement: column.verticalArrangement,
                horizontalAlignment: column.horizontalAlignment,
                action: column.action,
                isLazy: column.isLazy as? Bool
            )
            
            return AnyView(ui.inflate())
            
        case let image as Component.Drawable:
            let ui = ComponentBoxUI.Image(id: image.id, name: image.name, url: image.url, contentDescription: image.contentDescription, modifier: image.modifier, alignment: image.alignment, contentScale: image.contentScale)
            return AnyView(ui.inflate())
            
        case let icon as Component.Vector:
            let ui = ComponentBoxUI.Icon(id: icon.id, name: icon.name, modifier: icon.modifier, alignment: icon.alignment, contentScale: icon.contentScale, color: icon.color)
            return AnyView(ui.inflate())
            
        case let row as Component.Row:
            let ui = ComponentBoxUI.Row(
                id: row.id,
                components: row.components as? [componentbox.Component],
                modifier: row.modifier,
                horizontalArrangement: row.horizontalArrangement,
                verticalAlignment: row.verticalAlignment,
                action: row.action,
                isLazy: row.isLazy as? Bool
            )
            
            return AnyView(ui.inflate())
            
        case let text as Component.Text:
            let ui = ComponentBoxUI.Text(id: text.id, modifier: text.modifier, text: text.text, color: text.color, textStyle: text.textStyle)
            return AnyView(ui.inflate())
            
        default:
            return AnyView(HStack { })
        }
    }
}
