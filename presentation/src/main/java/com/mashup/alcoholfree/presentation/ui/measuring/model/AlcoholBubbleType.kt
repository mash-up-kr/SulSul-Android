package com.mashup.alcoholfree.presentation.ui.measuring.model

import com.mashup.alcoholfree.presentation.R

enum class AlcoholBubbleType(val id: Int, val iconResId: Int) {
    SOJU(id = 0, iconResId = R.drawable.ic_bubble_soju),
    BEER(id = 1, iconResId = R.drawable.ic_bubble_macju),
    WINE(id = 2, iconResId = R.drawable.ic_bubble_wine),
    KAOLIANGJU(id = 3, iconResId = R.drawable.ic_bubble_goryanju),
}
