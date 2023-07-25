package com.mashup.alcoholfree.presentation.ui.measureresult.model

import com.mashup.alcoholfree.presentation.R

enum class AlcoholType(val title: String, val iconResId: Int) {
    SOJU(title = "소주", iconResId = R.drawable.ic_soju_s),
    BEER(title = "맥주", iconResId = R.drawable.ic_macju_s),
    KAOLIANGJU(title = "고량주", iconResId = R.drawable.ic_goryangju_s),
    WINE(title = "와인", iconResId = R.drawable.ic_wine_s),
    WHISKY(title = "위스키", iconResId = R.drawable.ic_whisky_s),
}
