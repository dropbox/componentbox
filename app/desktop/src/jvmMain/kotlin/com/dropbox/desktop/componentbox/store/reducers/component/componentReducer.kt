package com.dropbox.desktop.componentbox.store.reducers.component

import com.dropbox.desktop.componentbox.store.actions.ComponentAction
import com.dropbox.desktop.componentbox.store.reducers.component.main.addNode
import com.dropbox.desktop.componentbox.store.reducers.component.main.clear
import com.dropbox.desktop.componentbox.store.reducers.component.main.clearActiveNode
import com.dropbox.desktop.componentbox.store.reducers.component.main.removeNode
import com.dropbox.desktop.componentbox.store.reducers.component.main.setAction
import com.dropbox.desktop.componentbox.store.reducers.component.main.setActiveNode
import com.dropbox.desktop.componentbox.store.reducers.component.main.setAlignment
import com.dropbox.desktop.componentbox.store.reducers.component.main.setBackground
import com.dropbox.desktop.componentbox.store.reducers.component.main.setButtonVariant
import com.dropbox.desktop.componentbox.store.reducers.component.main.setColor
import com.dropbox.desktop.componentbox.store.reducers.component.main.setContentScale
import com.dropbox.desktop.componentbox.store.reducers.component.main.setDrawableName
import com.dropbox.desktop.componentbox.store.reducers.component.main.setFillMaxHeight
import com.dropbox.desktop.componentbox.store.reducers.component.main.setFillMaxSize
import com.dropbox.desktop.componentbox.store.reducers.component.main.setFillMaxWidth
import com.dropbox.desktop.componentbox.store.reducers.component.main.setHeight
import com.dropbox.desktop.componentbox.store.reducers.component.main.setHorizontalAlignment
import com.dropbox.desktop.componentbox.store.reducers.component.main.setHorizontalArrangement
import com.dropbox.desktop.componentbox.store.reducers.component.main.setIsChecked
import com.dropbox.desktop.componentbox.store.reducers.component.main.setIsEnabled
import com.dropbox.desktop.componentbox.store.reducers.component.main.setIsLazy
import com.dropbox.desktop.componentbox.store.reducers.component.main.setMargin
import com.dropbox.desktop.componentbox.store.reducers.component.main.setModifier
import com.dropbox.desktop.componentbox.store.reducers.component.main.setPadding
import com.dropbox.desktop.componentbox.store.reducers.component.main.setText
import com.dropbox.desktop.componentbox.store.reducers.component.main.setTextStyle
import com.dropbox.desktop.componentbox.store.reducers.component.main.setVectorName
import com.dropbox.desktop.componentbox.store.reducers.component.main.setVerticalAlignment
import com.dropbox.desktop.componentbox.store.reducers.component.main.setVerticalArrangement
import com.dropbox.desktop.componentbox.store.reducers.component.main.setWeight
import com.dropbox.desktop.componentbox.store.reducers.component.main.setWidth
import com.dropbox.desktop.componentbox.store.state.ComponentState

fun componentReducer(state: ComponentState, action: Any): ComponentState {
    return state.copy().let { nextState ->
        when (action) {
            ComponentAction.Clear -> nextState.clear()
            ComponentAction.ClearActiveNode -> nextState.clearActiveNode()

            is ComponentAction.AddNode -> nextState.addNode(action)
            is ComponentAction.RemoveNode -> nextState.removeNode(action)

            is ComponentAction.SetAction -> nextState.setAction(action)
            is ComponentAction.SetActiveNode -> nextState.setActiveNode(action)
            is ComponentAction.SetButtonVariant -> nextState.setButtonVariant(action)
            is ComponentAction.SetColor -> nextState.setColor(action)
            is ComponentAction.SetContentScale -> nextState.setContentScale(action)
            is ComponentAction.SetDrawableName -> nextState.setDrawableName(action)
            is ComponentAction.SetIsChecked -> nextState.setIsChecked(action)
            is ComponentAction.SetIsEnabled -> nextState.setIsEnabled(action)
            is ComponentAction.SetIsLazy -> nextState.setIsLazy(action)
            is ComponentAction.SetText -> nextState.setText(action)
            is ComponentAction.SetTextStyle -> nextState.setTextStyle(action)
            is ComponentAction.SetVectorName -> nextState.setVectorName(action)

            is ComponentAction.ModifierAction.SetBackground -> nextState.setBackground(action)
            is ComponentAction.ModifierAction.SetFillMaxHeight -> nextState.setFillMaxHeight(action)
            is ComponentAction.ModifierAction.SetFillMaxSize -> nextState.setFillMaxSize(action)
            is ComponentAction.ModifierAction.SetFillMaxWidth -> nextState.setFillMaxWidth(action)
            is ComponentAction.ModifierAction.SetHeight -> nextState.setHeight(action)
            is ComponentAction.ModifierAction.SetMargin -> nextState.setMargin(action)
            is ComponentAction.ModifierAction.SetModifier -> nextState.setModifier(action)
            is ComponentAction.ModifierAction.SetPadding -> nextState.setPadding(action)
            is ComponentAction.ModifierAction.SetWeight -> nextState.setWeight(action)
            is ComponentAction.ModifierAction.SetWidth -> nextState.setWidth(action)

            is ComponentAction.LayoutAction.SetAlignment -> nextState.setAlignment(action)
            is ComponentAction.LayoutAction.SetHorizontalAlignment -> nextState.setHorizontalAlignment(action)
            is ComponentAction.LayoutAction.SetHorizontalArrangement -> nextState.setHorizontalArrangement(action)
            is ComponentAction.LayoutAction.SetVerticalAlignment -> nextState.setVerticalAlignment(action)
            is ComponentAction.LayoutAction.SetVerticalArrangement -> nextState.setVerticalArrangement(action)

            else -> nextState
        }
    }
}