package com.mashup.alcoholfree.presentation.ui.component.model

import androidx.compose.ui.graphics.Color
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.theme.BeerGradient
import com.mashup.alcoholfree.presentation.ui.theme.GoryangjuGradient
import com.mashup.alcoholfree.presentation.ui.theme.SojuGradient
import com.mashup.alcoholfree.presentation.ui.theme.WineGradient

enum class SulSulPromiseCardAlcohol(
    val imageResId: Int,
    val color: Color,
) {
    SOJU(
        imageResId = R.drawable.card_soju,
        color = SojuGradient,
    ),
    WINE(
        imageResId = R.drawable.card_wine,
        color = WineGradient,
    ),
    BEER(
        imageResId = R.drawable.card_beer,
        color = BeerGradient,
    ),
    GORYANGJU(
        imageResId = R.drawable.card_goryangju,
        color = GoryangjuGradient,
    ),
}
