package com.mashup.alcoholfree.presentation.ui.home.model

import androidx.compose.ui.graphics.Color
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.theme.BlueGradient2
import com.mashup.alcoholfree.presentation.ui.theme.GreenGradient2
import com.mashup.alcoholfree.presentation.ui.theme.OrangeGradient2
import com.mashup.alcoholfree.presentation.ui.theme.PurpleGradient2

enum class AlcoholPromiseCardType(
    val imageResId: Int,
    val color: Color,
) {
    SOJU(
        imageResId = R.drawable.card_soju,
        color = GreenGradient2,
    ),
    WINE(
        imageResId = R.drawable.card_wine,
        color = PurpleGradient2,
    ),
    BEER(
        imageResId = R.drawable.card_beer,
        color = OrangeGradient2,
    ),
    GORYANGJU(
        imageResId = R.drawable.card_goryangju,
        color = GreenGradient2,
    ),
    WHISKY(
        imageResId = R.drawable.card_whisky,
        color = BlueGradient2,
    ),
}
