package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.domain.model.PromiseCard
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholPromiseCardType.Companion.getCardType
import com.mashup.alcoholfree.presentation.utils.DateFormatter
import com.mashup.alcoholfree.presentation.utils.ImmutableList

data class AlcoholPromiseCardUiModel(
    val cardType: AlcoholPromiseCardType,
    val drinks: List<DrinkUiModel>,
    val drankDate: String,
    val subTitleText: String,
)

fun PromiseCard.toUiModel(): AlcoholPromiseCardUiModel {
    return AlcoholPromiseCardUiModel(
        cardType = getCardType(cardType),
        drinks = drinks.map { it.toUiModel() },
        drankDate = DateFormatter.dateFormat(drankDate),
        // TODO("칭호 필요합니당")
        subTitleText = "임시",
    )
}

fun AlcoholPromiseCardUiModel.toUiState(): AlcoholPromiseCardState {
    return AlcoholPromiseCardState(
        cardType = cardType,
        drinks = ImmutableList(drinks),
        drankDate = drankDate,
        subTitleText = subTitleText,
    )
}
