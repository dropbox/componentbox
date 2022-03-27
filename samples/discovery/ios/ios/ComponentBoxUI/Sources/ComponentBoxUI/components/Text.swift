//
// Created by Matt Ramotar on 3/27/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//

import Foundation
import SwiftUI
import componentbox

@available(iOS 14.0, *)
struct ComponentBoxUIText: View, Identifiable {
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
