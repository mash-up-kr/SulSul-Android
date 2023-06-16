package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.presentation.R

enum class AlcoholLevel(val title: String, val badgeText: String, val imageResId: Int) {
    LEVEL1(title = "응애 술요미!", badgeText = "귀엽네", imageResId = R.drawable.img_baby),
    LEVEL2(title = "그저 술반인", badgeText = "가자~", imageResId = R.drawable.img_common),
    LEVEL3(title = "이쯤되면 술잘알", badgeText = "술 좀 치네", imageResId = R.drawable.img_master),
    LEVEL4(title = "알코올이 낳은 괴물", badgeText = "미쳤다", imageResId = R.drawable.img_ghost),
    LEVEL5(title = "음주가무 천상계", badgeText = "알콜 마스터", imageResId = R.drawable.img_heaven),
    LEVEL6(title = "Alcohol God", badgeText = "무서울게 없다", imageResId = R.drawable.img_god),
}
