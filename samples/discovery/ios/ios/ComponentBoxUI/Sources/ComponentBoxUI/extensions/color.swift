//
// Created by Matt Ramotar on 3/27/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//

import Foundation
import SwiftUI

@available(iOS 14.0, *)
extension Color {
    static let ui = Color.UI()

    struct UI {
        let backgroundElevated = Color("BackgroundElevated")
        let primary = Color("Primary")
        let onBackground = Color("OnBackground")
        let opacity1 = Color("Opacity1")
        let faintText = Color("FaintText")
        let successFill = Color("SuccessFill")
        let background = Color("Background")
        let onPrimary = Color("OnPrimary")
    }
}

@available(iOS 14.0, *)
extension String {
    func ui() -> Color {
        switch self {
            
        case "Standard background elevated":
            return Color.ui.backgroundElevated
            
        case "Opacity 1":
            return Color.ui.opacity1

        case "On background":
            return Color.ui.onBackground
            
        case "Success fill":
            return Color.ui.successFill

        case "Primary":
            return Color.ui.primary

        case "Faint text":
            return Color.ui.faintText
            
        case "Background":
            return Color.ui.background
            
        case "On primary":
            return Color.ui.onPrimary

        default:
            return Color.ui.onBackground
        }
    }
}
