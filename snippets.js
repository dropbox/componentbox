export const simpleScreen = `
@Composable
fun Screen() {
    val zipline = ComponentBoxZipline(getZiplineUrl(), getScript())
    val presenter = ComponentBoxPresenter(zipline)

    ComponentBoxView(
        componentBoxUrl = getComponentBoxUrl(),
        presenter = presenter,
        context = getContext(),
        Loading = { Loading() },
        Fallback = { Fallback() }
    )
}
`;

export const simpleFragment = `
class Screen(
    private val componentBoxUrl: String,
    private val presenter: ComponentBoxPresenter,
    private val context: Context
): ComponentBoxFragment()
`


export const activity = `
@Composable
actual fun Component.Inflate() {
    when (this) {
        is Component.Box -> this.Inflate()
        is Component.Button -> this.Inflate()
        is Component.Column -> this.Inflate()
        is Component.Drawable -> this.Inflate()
        is Component.Row -> this.Inflate()
        is Component.Switch -> this.Inflate()
        is Component.Text -> this.Inflate()
        is Component.Vector -> this.Inflate()
        is Component.Surface -> this.Inflate()
    }
}
`

