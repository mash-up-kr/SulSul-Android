package com.mashup.alcoholfree.presentation.ui.home.model

data class AlcoholPromiseCardState(
    val drinks: List<Drink>,
    val drankDate: String,
    val subTitleText: String,
) {
    companion object {
        fun getAlcoholType(type: Drink): AlcoholPromiseCardType {
            return when (type.alcoholType) {
                "소주" -> AlcoholPromiseCardType.SOJU
                "와인" -> AlcoholPromiseCardType.WINE
                "맥주" -> AlcoholPromiseCardType.BEER
                "고량주" -> AlcoholPromiseCardType.GORYANGJU
                // TODO: 술을 안마셨다면 나중에 빈 컴포넌트 색깔 넣으면 될듯 합니다~
                else -> AlcoholPromiseCardType.SOJU
            }
        }
    }
}
