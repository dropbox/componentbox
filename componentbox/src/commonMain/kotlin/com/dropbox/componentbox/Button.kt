package com.dropbox.componentbox

import kotlinx.serialization.Serializable

/**
 * The base class for a button.
 * @property modifier The modifier to be applied to the button.
 * @property enabled Whether the button should be enabled or disabled.
 */
@Serializable
sealed class Button : Component {

    abstract val modifier: Modifier
    abstract val enabled: Boolean
    abstract val onClick: Action?

    /**
     * A button with a contained style.
     *
     * @property backgroundColor The background color of the button.
     * @property contentColor The content color of the button.
     * @property elevation The elevation of the button.
     * @property shape The shape of the button.
     */
    sealed class Contained : Button() {
        abstract val backgroundColor: Color?
        abstract val contentColor: Color?
        abstract val elevation: Dp?
        abstract val shape: Shape?
        abstract val children: MutableList<Component>

        /**
         * A button with a contained style and executable event handler.
         * @property onClick The callback function to be called when the button is clicked.
         */
        data class Dynamic(
            override val modifier: Modifier = Modifier(),
            override val enabled: Boolean = true,
            override val onClick: Action.Lambda? = null,
            override val backgroundColor: Color? = null,
            override val contentColor: Color? = null,
            override val elevation: Dp? = null,
            override val shape: Shape? = null,
            override val children: MutableList<Component> = mutableListOf()
        ) : Contained() {
            fun child(component: Component) {
                children.add(component)
            }
        }

        /**
         * A button with a contained style and semantically identifiable event handler.
         * @property onClick The action to be performed when the button is clicked.
         */
        data class Static<Event : Any>(
            override val modifier: Modifier = Modifier(),
            override val enabled: Boolean = true,
            override val onClick: Action.Semantic<Event>? = null,
            override val backgroundColor: Color? = null,
            override val contentColor: Color? = null,
            override val elevation: Dp? = null,
            override val shape: Shape? = null,
            override val children: MutableList<Component> = mutableListOf()
        ) : Contained() {
            fun child(component: Component) {
                children.add(component)
            }
        }
    }


    /**
     * A button with a text style.
     *
     * @property contentColor: Color
     */
    sealed class Text : Button() {
        abstract val text: String
        abstract val contentColor: Color?

        data class Dynamic(
            override val modifier: Modifier = Modifier(),
            override val text: String,
            override val contentColor: Color? = null,
            override val enabled: Boolean = true,
            override val onClick: Action.Lambda? = null
        ) : Text()

        data class Static<Event : Any>(
            override val modifier: Modifier = Modifier(),
            override val text: String,
            override val contentColor: Color? = null,
            override val enabled: Boolean = true,
            override val onClick: Action.Semantic<Event>? = null
        ) : Text()
    }
}