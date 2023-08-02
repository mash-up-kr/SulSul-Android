package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.domain.model.PromiseCard
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholPromiseCardType.Companion.getCardType
import com.mashup.alcoholfree.presentation.utils.DateFormatter

data class AlcoholPromiseCardUiModel(
    val id: String,
    val cardType: AlcoholPromiseCardType,
    val drinks: String,
    val drankDate: String,
    val tier: String,
)

fun PromiseCard.toUiModel(): AlcoholPromiseCardUiModel {
    return AlcoholPromiseCardUiModel(
        id = reportId,
        cardType = getCardType(cardType),
        drinks = drinks.joinToString(", ") { drink ->
            "${drink.drinkType} ${drink.glasses}잔"
        },
        drankDate = DateFormatter.dateFormat(drankDate),
        tier = tier,
    )
}

fun AlcoholPromiseCardUiModel.toUiState(): AlcoholPromiseCardState {
    return AlcoholPromiseCardState(
        id = id,
        cardType = cardType,
        drinks = drinks,
        drankDate = drankDate,
        tier = tier,
    )
}
