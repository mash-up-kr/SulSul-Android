package com.mashup.alcoholfree.domain.usecase

import com.mashup.alcoholfree.domain.model.SulSulLevel

class GetSulSulLevelUseCase {
    operator fun invoke(cup: Int): SulSulLevel {
        return when (cup) {
            in 1..7 -> SulSulLevel.LEVEL1
            in 8..15 -> SulSulLevel.LEVEL2
            in 16..23 -> SulSulLevel.LEVEL3
            in 24..31 -> SulSulLevel.LEVEL4
            in 32..999 -> SulSulLevel.LEVEL5
            else -> throw IllegalArgumentException()
        }
    }
}
