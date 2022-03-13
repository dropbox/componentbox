package com.dropbox.desktop.componentbox.store.actions

import com.dropbox.desktop.componentbox.data.entities.Node
import com.dropbox.componentbox.foundation.Alignment
import com.dropbox.componentbox.foundation.Arrangement
import com.dropbox.componentbox.foundation.ContentScale
import com.dropbox.componentbox.foundation.Margin
import com.dropbox.componentbox.foundation.Modifier
import com.dropbox.componentbox.foundation.Padding

sealed class ComponentAction {

    data class AddNode(
        val node: Node,
        val parentId: String? = null,
        val index: Int? = null
    ) : ComponentAction()

    object Clear : ComponentAction()

    object ClearActiveNode : ComponentAction()

    data class RemoveNode(
        val id: String
    ) : ComponentAction()

    data class SetActiveNode(
        val node: Node
    ) : ComponentAction()

    data class SetButtonVariant(
        val id: String,
        val variant: String,
    ) : ComponentAction()

    data class SetColor(
        val id: String,
        val color: String,
    ) : ComponentAction()

    data class SetContentScale(
        val id: String,
        val contentScale: ContentScale
    ) : ComponentAction()

    data class SetDrawableName(
        val id: String,
        val name: String
    ) : ComponentAction()

    data class SetIsChecked(
        val id: String,
        val isChecked: Boolean
    ) : ComponentAction()

    data class SetIsEnabled(
        val id: String,
        val isEnabled: Boolean
    ) : ComponentAction()

    data class SetIsLazy(
        val id: String,
        val isLazy: Boolean
    ) : ComponentAction()

    data class SetAction(
        val id: String,
        val action: String
    ) : ComponentAction()

    data class SetText(
        val id: String,
        val text: String
    ) : ComponentAction()

    data class SetTextStyle(
        val id: String,
        val style: String
    ) : ComponentAction()

    data class SetVectorName(
        val id: String,
        val name: String
    ) : ComponentAction()

    sealed class LayoutAction : ComponentAction() {
        data class SetHorizontalArrangement(
            val id: String,
            val horizontalArrangement: Arrangement
        ) : LayoutAction()

        data class SetVerticalArrangement(
            val id: String,
            val verticalArrangement: Arrangement
        ) : ComponentAction()

        data class SetHorizontalAlignment(
            val id: String,
            val horizontalAlignment: Alignment
        ) : ComponentAction()

        data class SetVerticalAlignment(
            val id: String,
            val verticalAlignment: Alignment
        ) : ComponentAction()

        data class SetAlignment(
            val id: String,
            val alignment: Alignment
        ) : ComponentAction()
    }

    sealed class ModifierAction : ComponentAction() {
        data class SetModifier(
            val id: String,
            val modifier: Modifier
        ) : ModifierAction()

        data class SetFillMaxSize(
            val id: String,
            val fillMaxSize: Boolean
        ) : ModifierAction()

        data class SetFillMaxHeight(
            val id: String,
            val fillMaxHeight: Boolean
        ) : ModifierAction()

        data class SetFillMaxWidth(
            val id: String,
            val fillMaxWidth: Boolean
        ) : ModifierAction()

        data class SetHeight(
            val id: String,
            val height: Int
        ) : ModifierAction()

        data class SetWidth(
            val id: String,
            val width: Int
        ) : ModifierAction()

        data class SetPadding(
            val id: String,
            val padding: Padding
        ) : ModifierAction()

        data class SetMargin(
            val id: String,
            val margin: Margin
        ) : ModifierAction()

        data class SetBackground(
            val id: String,
            val background: String
        ) : ModifierAction()

        data class SetWeight(
            val id: String,
            val weight: Float
        ) : ModifierAction()
    }
}