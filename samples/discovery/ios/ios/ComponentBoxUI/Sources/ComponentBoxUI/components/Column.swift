//
// Created by Matt Ramotar on 3/27/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//

import Foundation
import SwiftUI
import componentbox

@available(iOS 14.0, *)
struct ComponentBoxUIColumn: View, Identifiable {
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
                        component.inflate()
                    }
                }.frame(maxWidth: .infinity).padding(padding).background(backgroundColor)
            } else {
                VStack {
                    ForEach(self.components!, id: \.self) { component in
                        component.inflate()
                    }
                }.frame(maxWidth: .infinity, alignment: .center).padding(padding).background(backgroundColor)
            }
        }
    }
}
