package com.mashup.alcoholfree.presentation.measure_result.model

import com.mashup.alcoholfree.presentation.R

enum class AlcoholType(val title: String, val iconResId: Int) {
    SOJU(title = "소주", iconResId = R.drawable.icon_soju),
    BEER(title = "맥주", iconResId = R.drawable.icon_soju),
    KAOLIANGJU(title = "고량주", iconResId = R.drawable.icon_soju),
    WINE(title = "와인", iconResId = R.drawable.icon_soju),
}
