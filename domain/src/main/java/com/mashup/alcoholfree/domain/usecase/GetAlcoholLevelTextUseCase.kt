package com.mashup.alcoholfree.domain.usecase

class GetAlcoholLevelTextUseCase {
    operator fun invoke(cup: Int): String {
        return when(cup) {
            in 1..7 -> "귀엽네"
            in 8 .. 15 -> "가자~"
            in 16 .. 23 -> "술 좀 치네"
            in 24 .. 31 -> "미쳤다"
            else -> "알콜 마스터"
        }
    }
}
