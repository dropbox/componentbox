//
// Created by Matt Ramotar on 3/27/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.

import Foundation
import SwiftUI
import componentbox


@available(iOS 14.0, *)
public struct ComponentBoxScreen: View, Identifiable {
    public let id: String
    let title: String?
    let verticalArrangement: componentbox.Arrangement?
    let horizontalAlignment: componentbox.Alignment?
    let components: [componentbox.Component]?
    
    public init(id: String, title: String?, verticalArrangement: componentbox.Arrangement?, horizontalAlignment: componentbox.Alignment?, components: [componentbox.Component]?) {
        self.id = id
        self.title = title
        self.verticalArrangement = verticalArrangement
        self.horizontalAlignment = horizontalAlignment
        self.components = components
    }

    public var body: some View {

        if (self.components?.isEmpty == false) {

        VStack {
            ForEach(self.components!, id: \.self) { component in
                component.inflate()
            }
        }.frame(maxWidth: .infinity, maxHeight: .infinity).padding(0)
        }
    }
}

