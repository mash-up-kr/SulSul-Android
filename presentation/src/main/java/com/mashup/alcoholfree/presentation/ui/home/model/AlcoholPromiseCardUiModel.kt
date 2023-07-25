package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.domain.model.PromiseCard
import com.mashup.alcoholfree.presentation.utils.ImmutableList

data class AlcoholPromiseCardUiModel(
    val cardType: AlcoholPromiseCardType,
    val drinks: List<DrinkUiModel>,
    val drankDate: String,
    val subTitleText: String,
)

fun PromiseCard.toUiModel(): AlcoholPromiseCardUiModel {
    return AlcoholPromiseCardUiModel(
        cardType = getAlcoholPromiseCardType(cardType),
        drinks = drinks.map { it.toUiModel() },
        drankDate = drankDate,
        // TODO("칭호 필요합니당")
        subTitleText = "임시",
    )
}

fun getAlcoholPromiseCardType(type: String): AlcoholPromiseCardType {
    return when (type) {
        "소주" -> AlcoholPromiseCardType.SOJU
        "와인" -> AlcoholPromiseCardType.WINE
        "맥주" -> AlcoholPromiseCardType.BEER
        "고량주" -> AlcoholPromiseCardType.GORYANGJU
        "위스키" -> AlcoholPromiseCardType.WHISKY
        else -> throw IllegalArgumentException()
    }
}

fun AlcoholPromiseCardUiModel.toUiState(): AlcoholPromiseCardState {
    return AlcoholPromiseCardState(
        cardType = cardType,
        drinks = ImmutableList(drinks),
        drankDate = drankDate,
        subTitleText = subTitleText,
    )
}
