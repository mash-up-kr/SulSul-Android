package com.mashup.alcoholfree.presentation.ui.component.model

import androidx.compose.ui.text.TextStyle
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle2
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle3
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle4

enum class SulSulButtonSize(
    val horizontalPadding: Int,
    val verticalPadding: Int,
    val imagePadding: Int,
    val singleImagePadding: Int,
    val radius: Int,
    val textSize: TextStyle,
) {
    SMALL(8, 5, 4, 6, 10, SubTitle4),
    MIDDLE(12, 9, 4, 12, 12, SubTitle3),
    LARGE(16, 14, 8, 14, 16, SubTitle2),
}
