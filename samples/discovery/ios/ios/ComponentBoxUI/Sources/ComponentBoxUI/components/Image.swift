//
// Created by Matt Ramotar on 3/27/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//

import Foundation
import SwiftUI
import componentbox
import Combine

@available(iOS 14.0, *)
struct ComponentBoxUIImage: View, Identifiable {
    let id: String
    let name: String?
    let url: String?
    let contentDescription: String?
    let modifier: componentbox.Modifier?
    let alignment: componentbox.Alignment?
    let contentScale: componentbox.ContentScale?
    
    
    var fallbackImage : some View {
        SwiftUI.Image("placeholder").resizable().scaledToFit().frame(height: 200).clipped()
    }

    var body: some View {
        
        if (url != nil) {
            ComponentBoxAsyncImage(url: URL(string: url!)!, placeholder: {fallbackImage} )
        } else {
            fallbackImage
        }
    }
}


@available(iOS 14.0, *)
class ImageLoader: ObservableObject {
    @Published var image: UIImage?
    private let url: URL
    private var cancellable: AnyCancellable?

    init(url: URL) {
        self.url = url
    }

    deinit {
        cancel()
    }
    

    func load() {
        cancellable = URLSession.shared.dataTaskPublisher(for: url)
            .map { UIImage(data: $0.data) }
            .replaceError(with: nil)
            .receive(on: DispatchQueue.main)
            .sink { [weak self] in self?.image = $0 }
    }
    
    func cancel() {
        cancellable?.cancel()
    }
}

@available(iOS 14.0, *)
struct ComponentBoxAsyncImage<Placeholder: View> : View {
    
    @StateObject private var loader: ImageLoader
    private let placeholder: Placeholder

    init(url: URL, @ViewBuilder placeholder: () -> Placeholder) {
        self.placeholder = placeholder()
        _loader = StateObject(wrappedValue: ImageLoader(url: url))
    }

    var body: some View {
        content
            .onAppear(perform: loader.load)
    }
    
    private var content: some View {
        Group {
                   if loader.image != nil {
                       Image(uiImage: loader.image!)
                           .resizable()
                   } else {
                       placeholder
                   }
               }
    }
}
