package com.mashup.alcoholfree.presentation.ui.home.model

import com.mashup.alcoholfree.presentation.utils.ImmutableList

data class AlcoholPromiseCardState(
    val drinks: ImmutableList<DrinkUiModel>,
    val drankDate: String,
    val subTitleText: String,
) {
    companion object {
        fun getAlcoholType(type: DrinkUiModel): AlcoholPromiseCardType {
            return when (type.alcoholType) {
                "소주" -> AlcoholPromiseCardType.SOJU
                "와인" -> AlcoholPromiseCardType.WINE
                "맥주" -> AlcoholPromiseCardType.BEER
                "고량주" -> AlcoholPromiseCardType.GORYANGJU
                "위스키" -> AlcoholPromiseCardType.WHISKY
                // TODO: 술을 안마셨다면 나중에 빈 컴포넌트 색깔 넣으면 될듯 합니다~
                else -> AlcoholPromiseCardType.SOJU
            }
        }

        // TODO : 나중에 지워야 할 함수 입니다~ api 붙이고 모델 확정 되면 지우 시죵~
        fun sampleCardList(): List<AlcoholPromiseCardState> {
            return listOf(
                AlcoholPromiseCardState(
                    drinks = ImmutableList(
                        listOf(
                            DrinkUiModel("맥주", 2),
                            DrinkUiModel("와인", 1),
                        ),
                    ),
                    drankDate = "2023.08.21",
                    subTitleText = "술 좀 치네",
                ),
                AlcoholPromiseCardState(
                    drinks = ImmutableList(
                        listOf(
                            DrinkUiModel("소주", 3),
                            DrinkUiModel("와인", 1),
                        ),
                    ),
                    drankDate = "2023.08.22",
                    subTitleText = "귀엽네",
                ),
                AlcoholPromiseCardState(
                    drinks =
                    ImmutableList(
                        listOf(
                            DrinkUiModel("와인", 4),
                            DrinkUiModel("맥주", 1),
                        ),
                    ),
                    drankDate = "2023.08.23",
                    subTitleText = "술 좀 치네",
                ),
                AlcoholPromiseCardState(
                    drinks =
                    ImmutableList(
                        listOf(
                            DrinkUiModel("고량주", 5),
                            DrinkUiModel("와인", 1),
                        ),
                    ),
                    drankDate = "2023.08.24",
                    subTitleText = "술 좀 치네",
                ),
                AlcoholPromiseCardState(
                    drinks =
                    ImmutableList(
                        listOf(
                            DrinkUiModel("위스키", 5),
                            DrinkUiModel("와인", 1),
                        ),
                    ),
                    drankDate = "2023.08.24",
                    subTitleText = "술 좀 치네",
                ),
            )
        }
    }
}
