package com.mashup.alcoholfree.presentation.ui.component.model

import androidx.compose.ui.text.TextStyle
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle2
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle3
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle4

enum class SulSulButtonSize(
    val horizontalPadding: Int,
    val verticalPadding: Int,
    val imagePadding: Int,
    val radius: Int,
    val textStyle: TextStyle,
) {
    SMALL(
        horizontalPadding = 8,
        verticalPadding = 5,
        imagePadding = 4,
        radius = 10,
        textStyle = SubTitle4,
    ),
    MIDDLE(
        horizontalPadding = 12,
        verticalPadding = 9,
        imagePadding = 4,
        radius = 12,
        textStyle = SubTitle3,
    ),
    LARGE(
        horizontalPadding = 16,
        verticalPadding = 14,
        imagePadding = 8,
        radius = 16,
        textStyle = SubTitle2,
    ),
}
