package com.dropbox.componentbox.ui.theme

sealed class ComponentBoxIcon {
    sealed class ListView : ComponentBoxIcon() {
        object Line : ListView()
        object Fill : ListView()
    }

    sealed class Home : ComponentBoxIcon() {
        object Line : Home()
        object Fill : Home()
    }

    sealed class Image : ComponentBoxIcon() {
        object Line : Image()
        object Fill : Image()
    }

    sealed class TextBox : ComponentBoxIcon() {
        object Line : TextBox()
        object Fill : TextBox()
    }

    sealed class EarlyBird : ComponentBoxIcon() {
        object Line : EarlyBird()
    }

    sealed class Activity : ComponentBoxIcon() {
        object Line : Activity()
    }

    sealed class Table : ComponentBoxIcon() {
        object Line : Table()
    }

    sealed class Theme : ComponentBoxIcon() {
        object Line : Theme()
    }

    sealed class Settings : ComponentBoxIcon() {
        object Line : Settings()
    }

    sealed class Help : ComponentBoxIcon() {
        object Line : Help()
    }

    sealed class AddComment : ComponentBoxIcon() {
        object Line : AddComment()
    }

    sealed class Share : ComponentBoxIcon() {
        object Line : Share()
    }

    sealed class Heart : ComponentBoxIcon() {
        object Line : Heart()
    }

    sealed class Delete : ComponentBoxIcon() {
        object Line : Delete()
    }

    sealed class Twinkle1 : ComponentBoxIcon() {
        object Line : Twinkle1()
    }

    sealed class Twinkle2 : ComponentBoxIcon() {
        object Line : Twinkle2()
    }

    sealed class Square: ComponentBoxIcon() {
        object Line: Square()
    }

    sealed class Switcher: ComponentBoxIcon() {
        object Line: Switcher()
    }
}

fun ComponentBoxIcon.resourcePath() = when (this) {
    ComponentBoxIcon.ListView.Fill -> "drawable/ic_dig_list_view_fill.xml"
    ComponentBoxIcon.ListView.Line -> "drawable/ic_dig_list_view_line.xml"
    ComponentBoxIcon.Activity.Line -> "drawable/ic_dig_activity_line.xml"
    ComponentBoxIcon.AddComment.Line -> "drawable/ic_dig_add_comment_line.xml"
    ComponentBoxIcon.Delete.Line -> "drawable/ic_dig_delete_line.xml"
    ComponentBoxIcon.EarlyBird.Line -> "drawable/ic_dig_early_bird_line.xml"
    ComponentBoxIcon.Heart.Line -> "drawable/ic_dig_heart_line.xml"
    ComponentBoxIcon.Help.Line -> "drawable/ic_dig_help_line.xml"
    ComponentBoxIcon.Home.Fill -> "drawable/ic_dig_home_fill.xml"
    ComponentBoxIcon.Home.Line -> "drawable/ic_dig_home_line.xml"
    ComponentBoxIcon.Image.Fill -> "drawable/ic_dig_image_fill.xml"
    ComponentBoxIcon.Image.Line -> "drawable/ic_dig_image_line.xml"
    ComponentBoxIcon.Settings.Line -> "drawable/ic_dig_settings_line.xml"
    ComponentBoxIcon.Share.Line -> "drawable/ic_dig_share_line.xml"
    ComponentBoxIcon.Table.Line -> "drawable/ic_dig_table_line.xml"
    ComponentBoxIcon.TextBox.Fill -> "drawable/ic_dig_text_box_fill.xml"
    ComponentBoxIcon.TextBox.Line -> "drawable/ic_dig_text_box_line.xml"
    ComponentBoxIcon.Theme.Line -> "drawable/ic_dig_theme_line.xml"
    ComponentBoxIcon.Twinkle1.Line -> "drawable/ic_dig_twinkle_1_line.xml"
    ComponentBoxIcon.Twinkle2.Line -> "drawable/ic_dig_twinkle_2_line.xml"
    ComponentBoxIcon.Square.Line -> "drawable/ic_dig_square_line.xml"
    ComponentBoxIcon.Switcher.Line -> "drawable/ic_dig_switcher_line.xml"
}