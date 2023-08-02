package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.domain.model.PromiseCard
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholPromiseCardType.Companion.getCardType
import com.mashup.alcoholfree.presentation.utils.DateFormatter
import com.mashup.alcoholfree.presentation.utils.ImmutableList

data class AlcoholPromiseCardUiModel(
    val id: String,
    val cardType: AlcoholPromiseCardType,
    val drinks: List<DrinkUiModel>,
    val drankDate: String,
    val tier: String,
)

fun PromiseCard.toUiModel(): AlcoholPromiseCardUiModel {
    return AlcoholPromiseCardUiModel(
        id = reportId,
        cardType = getCardType(cardType),
        drinks = drinks.map { it.toUiModel() },
        drankDate = DateFormatter.dateFormat(drankDate),
        tier = tier,
    )
}

fun AlcoholPromiseCardUiModel.toUiState(): AlcoholPromiseCardState {
    return AlcoholPromiseCardState(
        id = id,
        cardType = cardType,
        drinks = ImmutableList(drinks),
        drankDate = drankDate,
        tier = tier,
    )
}
