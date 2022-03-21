//
//  inflate.swift
//  ios
//
//  Created by mramotar on 3/20/22.
//  Copyright © 2022 Dropbox, Inc. All rights reserved.
//

import Foundation
import componentbox
import SwiftUI


@available(iOS 14.0, *)
@ViewBuilder func inflate(component: Component) -> some View {
    switch component {
    case let box as Component.Box:
        ComponentBoxBoxView(id: box.id, components: box.components?.compactMap { $0 as? Component}, modifier: box.modifier, horizontalArrangement: box.horizontalArrangement, verticalAlignment: box.verticalAlignment, action: box.action)
    case let text as Component.Text:
        ComponentBoxTextView(id: text.id, modifier: text.modifier, text: text.text, color: text.color, textStyle: text.textStyle)
    case let column as Component.Column:
        ComponentBoxColumnView(id: column.id, components: column.components?.compactMap { $0 as? Component}, modifier: column.modifier, verticalArrangement: column.verticalArrangement, horizontalAlignment: column.horizontalAlignment, action: column.action, isLazy: column.isLazy as! Bool?  )
    case let row as Component.Row:
        ComponentBoxRowView(id: row.id, components: row.components?.compactMap { $0 as? Component}, modifier: row.modifier, horizontalArrangement: row.horizontalArrangement, verticalAlignment: row.verticalAlignment, action: row.action, isLazy: row.isLazy as! Bool?)
    case let image as Component.Drawable:
        ComponentBoxImageView(id: image.id, name: image.name, url: image.url, contentDescription: image.contentDescription, modifier: image.modifier, alignment: image.alignment, contentScale: image.contentScale)
    case let icon as Component.Vector:
        ComponentBoxIconView(id: icon.id, name: icon.name, modifier: icon.modifier, alignment: icon.alignment, contentScale: icon.contentScale, color: icon.color)
    case let button as Component.Button:
        ComponentBoxButtonView(id: button.id, components: button.components?.compactMap { $0 as? Component}, modifier: button.modifier, isEnabled: button.isEnabled as! Bool?, action: button.action, variant: button.variant)
    default:
        HStack { }
    }
}

@available(iOS 14.0, *)
struct ComponentBoxScreenView: View, Identifiable {
    let id: String
    let title: String?
    let verticalArrangement: componentbox.Arrangement?
    let horizontalAlignment: componentbox.Alignment?
    let components: Array<componentbox.Component>?


    var body: some View {
        
        if (self.components?.isEmpty == false) {

        VStack {
            ForEach(self.components!, id: \.self) { component in
                inflate(component: component)
            }
        }.frame(maxWidth: .infinity, maxHeight: .infinity).padding(0)
        }
    }
}


@available(iOS 14.0, *)
struct ComponentBoxBoxView: View, Identifiable {
    let id: String
    let components: [componentbox.Component]?
    let modifier: componentbox.Modifier?
    let horizontalArrangement: componentbox.Arrangement?
    let verticalAlignment: componentbox.Alignment?
    let action: String?


    var body: some View {

        if (self.components != nil) {
            ZStack {
                ForEach(self.components!, id: \.self) { component in
                    inflate(component: component)
                }
            }
        }
    }
}

@available(iOS 14.0, *)
struct ComponentBoxRowView: View, Identifiable {
    let id: String
    let components: [componentbox.Component]?
    let modifier: componentbox.Modifier?
    let horizontalArrangement: componentbox.Arrangement?
    let verticalAlignment: componentbox.Alignment?
    let action: String?
    let isLazy: Bool?


    var body: some View {

        if (self.components != nil) {
            if (self.isLazy == true) {
                ScrollView {
                    ForEach(self.components!, id: \.self) { component in
                        inflate(component: component)
                    }
                }
            } else {
                HStack {
                    ForEach(self.components!, id: \.self) { component in
                        inflate(component: component)
                    }
                }.frame(maxWidth: modifier?.fillMaxWidth == true ? .infinity : .none, alignment: .leading)
            }
        }
    }
}

@available(iOS 14.0, *)
struct ComponentBoxColumnView: View, Identifiable {
    let id: String
    let components: Array<componentbox.Component>?
    let modifier: componentbox.Modifier?
    let verticalArrangement: componentbox.Arrangement?
    let horizontalAlignment: componentbox.Alignment?
    let action: String?
    let isLazy: Bool?


    var body: some View {
        
        let backgroundColor = modifier?.background != nil ? modifier!.background!.title.ui() : "Background".ui()
        
        let padding = modifier?.padding != nil ? modifier!.padding!.build() : EdgeInsets(top: 0, leading: 0, bottom: 0, trailing: 0)

        if (self.components != nil) {
            if (self.isLazy == true) {
                ScrollView {
                    ForEach(self.components!, id: \.self) { component in
                        inflate(component: component)
                    }
                }.frame(maxWidth: .infinity).padding(padding).background(backgroundColor)
            } else {
                VStack {
                    ForEach(self.components!, id: \.self) { component in
                        inflate(component: component)
                    }
                }.frame(maxWidth: .infinity, alignment: .center).padding(padding).background(backgroundColor)
            }
        }
    }
}



@available(iOS 14.0, *)
struct ComponentBoxTextView: View, Identifiable {
    let id: String
    let modifier: componentbox.Modifier?
    let text: String?
    let color: componentbox.Color?
    let textStyle: String?
    
    var body: some View {
        
        let isHeading = ["h1", "h2", "h3", "h4", "h5", "h6"].contains(self.textStyle)
        let color = color != nil ? color!.title.ui() : "On background".ui()

        if (isHeading) {
            SwiftUI.Text(text ?? "").sharpGroteskBold(style: .title3, color: color)
        } else {
            SwiftUI.Text(text ?? "").atlasGrotesk(style: .body, weight: .regular, color: color)
        }
    }
}


@available(iOS 14.0, *)
struct ComponentBoxImageView: View, Identifiable {
    let id: String
    let name: String?
    let url: String?
    let contentDescription: String?
    let modifier: componentbox.Modifier?
    let alignment: componentbox.Alignment?
    let contentScale: componentbox.ContentScale?
    
    var body: some View {
        SwiftUI.Image("traffic_road_blocked").resizable().scaledToFit().frame(height: 200).clipped()
    }
}

@available(iOS 14.0, *)
struct ComponentBoxIconView: View, Identifiable {
    let id: String
    let name: String?
    let modifier: componentbox.Modifier?
    let alignment: componentbox.Alignment?
    let contentScale: componentbox.ContentScale?
    let color: componentbox.Color?
    
    var body: some View {
        let foregroundColor =  color?.title != nil ? color!.title.ui() : "Success fill".ui()
        
        SwiftUI.Image("CheckmarkCircle.Fill").renderingMode(.template).foregroundColor(foregroundColor)
    }
}


@available(iOS 14.0, *)
struct ComponentBoxButtonView: View, Identifiable {
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
                inflate(component: component)
            
            }}.padding().frame(maxWidth: .infinity).background(Color.ui.primary)
    }
}


extension componentbox.Padding {
    func build() -> EdgeInsets {
        
        let top = CGFloat(self.top?.floatValue ?? 0)
        let bottom = CGFloat(self.bottom?.floatValue ?? 0)
        let leading = CGFloat(self.start?.floatValue ?? 0)
        let trailing = CGFloat(self.end?.floatValue ?? 0)
        
        return EdgeInsets(top: top, leading: leading, bottom: bottom, trailing: trailing)
    }
}
