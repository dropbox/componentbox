//
// Created by Matt Ramotar on 3/27/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//

import Foundation
import SwiftUI
import componentbox

@available(iOS 14.0, *)
struct ComponentBoxUIIcon: View, Identifiable {
    let id: String
    let name: String?
    let modifier: componentbox.Modifier?
    let alignment: componentbox.Alignment?
    let contentScale: componentbox.ContentScale?
    let color: componentbox.Color?
    
    func getForegroundColor() -> SwiftUI.Color {
        return color?.title != nil ? color!.title.ui() : "On background".ui()
    }

    var body: some View {
        if (name != nil) {
            SwiftUI.Image(name!).renderingMode(.template).foregroundColor(getForegroundColor())
        }
    }
}
