//
//  PlansScreenViewModel.swift
//  ios
//
//  Created by mramotar on 3/20/22.
//  Copyright © 2022 Dropbox, Inc. All rights reserved.
//

import Foundation
import componentbox
import KMPNativeCoroutinesAsync

class PlansScreenViewModel: ObservableObject {
    @Published var screen: ComponentBox.Screen?
    
    let client = ComponentBoxClient().freeze()
    
    init () {
        fetchComponentBox()
    }
    
    func fetchComponentBox() {
        Task {
            do {
                let response = try await asyncResult(for: client.fetchScreenNative(url: "https://api.componentbox.io/screens/1.json"))
                
                guard case let .success(val) = response  else {
                    return
                }
                screen = val
                
                
            } catch {
                print("FAILED \(error)")
            }
        }
    
    }
}
