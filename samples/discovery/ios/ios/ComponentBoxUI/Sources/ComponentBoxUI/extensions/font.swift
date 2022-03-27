//
// Created by Matt Ramotar on 3/27/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//


import Foundation
import SwiftUI

import Foundation


@available(iOS 14.0, *)
extension Font {
    @available(iOS 14.0, *)
    static func sharpGroteskBook(
            withStyle style: Font.TextStyle,
            size: CGFloat
    ) -> Font {
        .custom("SharpGroteskDBCyrBook20", size: size, relativeTo: style)
    }


    static func atlasGrotesk(
            withStyle style: Font.TextStyle,
            size: CGFloat,
            isBold: Bool = false
    ) -> Font {
        .custom("font0000000027e54b07", size: size, relativeTo: style).weight(isBold ? .bold : .regular)
    }
}


@available(iOS 14.0, *)
struct FontModifier: ViewModifier {

    var name: String
    var style: UIFont.TextStyle = .body
    var weight: Font.Weight = .regular
    var color: Color

    func body(content: Content) -> some View {
        content
                .font(Font.custom(name, size: UIFont.preferredFont(forTextStyle: style).pointSize)
                        .weight(weight))
                .foregroundColor(color)
    }

}


@available(iOS 14.0, *)
extension View {
    func sharpGroteskBook(style: UIFont.TextStyle, weight: Font.Weight, color: Color = Color.ui.onBackground) -> some View {
        self.modifier(FontModifier(name: "SharpGroteskDBCyrBook20", style: style, weight: weight, color: color))
    }

    func sharpGroteskBold(style: UIFont.TextStyle, color: Color = Color.ui.onBackground) -> some View {
        self.modifier(FontModifier(name: "SharpGroteskDBCyrMedium20", style: style, weight: .bold, color: color))
    }


    func atlasGroteskBold(style: UIFont.TextStyle, color: Color = Color.ui.onBackground) -> some View {
        self.modifier(FontModifier(name: "font0000000027e55806", style: style, weight: .bold, color: color))
    }

    func atlasGrotesk(style: UIFont.TextStyle, weight: Font.Weight, color: Color = Color.ui.onBackground) -> some View {
        self.modifier(FontModifier(name: "font0000000027e54b07", style: style, weight: weight, color: color))
    }
}
