package com.dropbox.componentbox

/**
 * The base class for a button.
 *
 * @property onClick The callback function to be called when the button is clicked.
 * @property modifier The modifier to be applied to the button.
 * @property enabled Whether the button should be enabled or disabled.
 */
sealed class Button : Component {

    abstract val modifier: Modifier
    abstract val enabled: Boolean
    abstract val onClick: (() -> Unit)?

    /**
     * A button with a contained style.
     *
     * @property backgroundColor The background color of the button.
     * @property contentColor The content color of the button.
     * @property elevation The elevation of the button.
     * @property shape The shape of the button.
     */
    data class Contained(
        override val modifier: Modifier = Modifier(),
        override val enabled: Boolean = true,
        override val onClick: (() -> Unit)? = null,
        val backgroundColor: Color,
        val contentColor: Color,
        val elevation: Dp,
        val shape: Shape,
        val children: MutableList<Component> = mutableListOf()
    ) : Button() {
        fun child(component: Component) {
            children.add(component)
        }
    }

    /**
     * A button with a text style.
     *
     * @property contentColor: Color
     */
    data class Text(
        override val modifier: Modifier = Modifier(),
        val text: String,
        val contentColor: Color? = null,
        override val enabled: Boolean = true,
        override val onClick: (() -> Unit)? = null
    ) : Button()
}