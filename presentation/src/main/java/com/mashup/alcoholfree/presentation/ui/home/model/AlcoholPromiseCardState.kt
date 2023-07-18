package com.mashup.alcoholfree.presentation.ui.home.model

data class AlcoholPromiseCardState(
    val drinks: List<Drink>,
    val drankDate: String,
    val subTitleText: String,
) {
    companion object {
        fun getAlcoholType(type: Drink): AlcoholCardType {
            return when (type.alcoholType) {
                "소주" -> AlcoholCardType.SOJU
                "와인" -> AlcoholCardType.WINE
                "맥주" -> AlcoholCardType.BEER
                "고량주" -> AlcoholCardType.GORYANGJU
                // TODO: 술을 안마셨다면 나중에 빈 컴포넌트 색깔 넣으면 될듯 합니다~
                else -> AlcoholCardType.SOJU
            }
        }
    }
}
