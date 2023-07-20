package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.presentation.utils.ImmutableList

data class AlcoholPromiseCardState(
    val drinks: ImmutableList<Drink>,
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

        fun sampleCardList(): List<AlcoholPromiseCardState> {
            return listOf(
                AlcoholPromiseCardState(
                    drinks = ImmutableList(
                        listOf(
                            Drink("맥주", 2),
                            Drink("와인", 1),
                        ),
                    ),
                    drankDate = "2023.08.21",
                    subTitleText = "술 좀 치네",
                ),
                AlcoholPromiseCardState(
                    drinks = ImmutableList(
                        listOf(
                            Drink("소주", 3),
                            Drink("와인", 1),
                        ),
                    ),
                    drankDate = "2023.08.22",
                    subTitleText = "귀엽네",
                ),
                AlcoholPromiseCardState(
                    drinks =
                    ImmutableList(
                        listOf(
                            Drink("와인", 4),
                            Drink("맥주", 1),
                        ),
                    ),
                    drankDate = "2023.08.23",
                    subTitleText = "술 좀 치네",
                ),
                AlcoholPromiseCardState(
                    drinks =
                    ImmutableList(
                        listOf(
                            Drink("고량주", 5),
                            Drink("와인", 1),
                        ),
                    ),
                    drankDate = "2023.08.24",
                    subTitleText = "술 좀 치네",
                ),
            )
        }
    }
}
