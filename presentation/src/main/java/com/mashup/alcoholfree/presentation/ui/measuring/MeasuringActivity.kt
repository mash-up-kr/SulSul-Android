package com.mashup.alcoholfree.presentation.ui.measuring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mashup.alcoholfree.presentation.ui.measuring.model.AlcoholBubbleType

class MeasuringActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeasuringScreen(
                totalCount = 25,
                records = "와인 2잔 · 소주 2잔 · 맥주 3잔",
                level = "미쳤다",
                currentAlcoholType = AlcoholBubbleType.SOJU,
                onMeasureFinishClick = {},
                onBackButtonClick = {}
            )
        }
    }
}
