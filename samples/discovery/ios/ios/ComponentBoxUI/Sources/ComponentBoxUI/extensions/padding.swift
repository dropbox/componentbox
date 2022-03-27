//
// Created by Matt Ramotar on 3/27/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//

import Foundation
import SwiftUI
import componentbox

@available(iOS 14.0, *)
extension componentbox.Padding {
    func build() -> EdgeInsets {

        let top = CGFloat(self.top?.floatValue ?? 0)
        let bottom = CGFloat(self.bottom?.floatValue ?? 0)
        let leading = CGFloat(self.start?.floatValue ?? 0)
        let trailing = CGFloat(self.end?.floatValue ?? 0)

        return EdgeInsets(top: top, leading: leading, bottom: bottom, trailing: trailing)
    }
}
