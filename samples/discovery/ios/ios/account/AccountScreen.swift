//
// Created by Matt Ramotar on 3/18/22.
// Copyright (c) 2022 Dropbox, Inc. All rights reserved.
//

import Foundation
import SwiftUI

@available(iOS 14.0, *)
struct AccountScreen: View {


    var body: some View {
        NavigationView {
            AccountScreenContent()
                    .navigationTitle("Account")
                    .toolbar {
                        ToolbarItem(placement: ToolbarItemPlacement.primaryAction) {
                            Image("Settings.Line").resizable().frame(width: 32.0, height: 32.0)
                        }
                    }
        }
    }
}

@available(iOS 14.0, *)
private struct AccountScreenContent: View {
    var body: some View {

        ScrollView {

            HStack(spacing: 20.0) {

                HStack {
                    ZStack(alignment: .bottomTrailing) {
                        Image("tag").resizable().scaledToFill().clipShape(Circle()).frame(width: 72.0, height: 72.0).clipped()

                        Image("Edit.Line").resizable().background(Color.white).scaledToFill().clipShape(Circle()).frame(width: 24.0, height: 24.0, alignment: .bottomTrailing).shadow(radius: 8.0)
                    }

                    VStack(alignment: .leading) {
                        Text("Tag Ramotar").sharpGroteskBold(style: .title3)
                        Text("tag@dropbox.com").atlasGrotesk(style: .body, weight: .regular)
                    }
                            .padding([.leading], 16).frame(alignment: .leading)

                }
                        .frame(maxWidth: .infinity, alignment: .leading)

                Image("switcher").resizable().frame(width: 32.0, height: 32.0)

            } // HStack
                    .frame(maxWidth: .infinity, alignment: .leading).padding().background(Color.white.shadow(radius: 4, x: 0, y: 0)
                            .mask(Rectangle().padding(.bottom, -8)))


            AccountDetails().onAppear {

                for family in UIFont.familyNames.sorted() {
                    let names = UIFont.fontNames(forFamilyName: family)
                    print("Family: \(family) Font names: \(names)")
                }
            }

            AccountFeatures()


        } // VStack
                .frame(maxWidth: .infinity, maxHeight: .infinity, alignment: Alignment.top).background(Color(hex: "#F3F3F3"))
    }
}

@available(iOS 14.0, *)
private struct AccountFeatures: View {

    var fakeFeatures = [
        FeatureCardModel(id: UUID(), imageNameLeading: "syncing", imageNameTrailing: "arrow right", text: "Sync", subtext: "All your content everywhere", accentColor: "OnBackground"),
        FeatureCardModel(id: UUID(), imageNameLeading: "scan", imageNameTrailing: "arrow right", text: "Doc scanner", subtext: "Scan receipts and documents", accentColor: "OnBackground"),
        FeatureCardModel(id: UUID(), imageNameLeading: "member transfer", imageNameTrailing: "arrow right", text: "Transfer", subtext: "Send large files securely", accentColor: "OnBackground"),
        FeatureCardModel(id: UUID(), imageNameLeading: "twinkle 2", imageNameTrailing: "arrow right", text: "Explore", subtext: "Explore your plus features", accentColor: "Primary")
    ]

    var body: some View {
        Surface {
            VStack(alignment: .leading) {
                Text("Your features").sharpGroteskBook(style: .title3, weight: .bold)
                ForEach(fakeFeatures, id: \.id) { fakeFeature in
                    FeatureCardView(model: fakeFeature)
                }

            }
        }
    }
}


@available(iOS 14.0, *)
private struct AccountDetails: View {
    var body: some View {
        VStack {
            HStack {

                HStack {
                    Image("Dropbox").resizable().renderingMode(.template).foregroundColor(Color.ui.primary).frame(width: 40, height: 40)

                    Text("Dropbox Basic").sharpGroteskBook(style: .title3, weight: .regular)
                }
                        .frame(maxWidth: .infinity, alignment: .leading)

                Button {
                } label: {
                    Text("Upgrade").sharpGroteskBold(style: .body, color: .white)
                }
                        .buttonStyle(PrimaryButton())


            }
                    .padding()

            Divider().frame(maxWidth: .infinity)

            HStack {

                VStack {

                    HStack {
                        Image("space").resizable().frame(width: 28, height: 28)
                        Text("1.5 GB").atlasGrotesk(style: .title3, weight: .regular)
                    }

                    Text("Storage used").atlasGrotesk(style: .subheadline, weight: .regular)

                }
                        .frame(maxWidth: .infinity)

                Divider().frame(maxHeight: 100)

                VStack {

                    HStack {
                        Image("mobile").resizable().frame(width: 28, height: 28)
                        Text("2/3").atlasGrotesk(style: .title3, weight: .regular)
                    }

                    Text("Devices linked").atlasGrotesk(style: .subheadline, weight: .regular)

                }
                        .frame(maxWidth: .infinity)
            }.padding()

            Button {
            } label: {
                Text("Account details").sharpGroteskBold(style: .body, color: Color.ui.onBackground)
            }
                    .buttonStyle(SecondaryButton(fillMaxWidth: true))

        }
                .padding().background(Color.white.shadow(radius: 4, x: 0, y: 0)
                        .mask(Rectangle().padding(.bottom, -8)))
    }
}


@available(iOS 14.0, *)
struct PrimaryButton: ButtonStyle {

    func makeBody(configuration: Self.Configuration) -> some View {
        configuration.label
                .padding(12)
                .background(Color.ui.primary)
    }
}

@available(iOS 14.0, *)
struct SecondaryButton: ButtonStyle {
    let fillMaxWidth: Bool


    init(fillMaxWidth: Bool = false) {
        self.fillMaxWidth = fillMaxWidth
    }

    func makeBody(configuration: Self.Configuration) -> some View {
        configuration.label
                .padding(12)
                .frame(maxWidth: fillMaxWidth ? .infinity : .none)
                .foregroundColor(Color.black)
                .font(.sharpGroteskBook(withStyle: .title3, size: 16))
                .background(Color.ui.opacity1)

    }
}


@available(iOS 14.0, *)
struct Surface<Content: View>: View {
    let content: () -> Content

    public init(@ViewBuilder content: @escaping () -> Content) {
        self.content = content
    }

    var body: some View {
        content().padding().background(Color.white.shadow(radius: 1, x: 0, y: 2)
                .mask(Rectangle().padding(.bottom, -2)))
    }

}


@available(iOS 14.0, *)
struct FeatureCardView: View {
    let model: FeatureCardModel

    var body: some View {
        HStack {

            HStack(spacing: 16) {
                Image(model.imageNameLeading).renderingMode(.template).foregroundColor(model.accentColor.ui())

                VStack(alignment: .leading, spacing: 8) {
                    SwiftUI.Text(model.text).atlasGrotesk(style: .body, weight: .regular, color: model.accentColor.ui())
                    SwiftUI.Text(model.subtext).atlasGrotesk(style: .caption1, weight: .regular, color: model.accentColor == "Primary" ? model.accentColor.ui() : Color.ui.faintText)
                }
            }
                    .frame(maxWidth: .infinity, alignment: .leading)

            Image(model.imageNameTrailing).renderingMode(.template).foregroundColor(model.accentColor.ui())
        }
                .padding().frame(maxWidth: .infinity).background(Color.ui.backgroundElevated)
    }
}

struct FeatureCardModel: Identifiable {
    let id: UUID
    let imageNameLeading: String
    let imageNameTrailing: String
    let text: String
    let subtext: String
    let accentColor: String
}

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
