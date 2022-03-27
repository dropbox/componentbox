//
// Created by Matt Ramotar on 3/27/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//

import Foundation
import SwiftUI
import componentbox

@available(iOS 14.0, *)
struct ComponentBoxUIRow: View, Identifiable {
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
                        component.inflate()
                    }
                }
            } else {
                HStack {
                    ForEach(self.components!, id: \.self) { component in
                        component.inflate()
                    }
                }.frame(maxWidth: modifier?.fillMaxWidth == true ? .infinity : .none, alignment: .leading)
            }
        }
    }
}
