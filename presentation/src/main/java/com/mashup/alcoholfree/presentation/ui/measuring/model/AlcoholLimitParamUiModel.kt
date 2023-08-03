package com.mashup.alcoholfree.presentation.ui.measuring.model

import com.mashup.alcoholfree.domain.model.AlcoholLimitParam
import com.mashup.alcoholfree.presentation.ui.home.model.DrinkUiModel
import com.mashup.alcoholfree.presentation.ui.home.model.toDomainModel

data class AlcoholLimitParamUiModel(
    val drinks: List<DrinkUiModel>,
)

fun AlcoholLimitParamUiModel.toDomainModel() =
    AlcoholLimitParam(
        drinks = drinks.map {
            it.toDomainModel()
        },
    )
