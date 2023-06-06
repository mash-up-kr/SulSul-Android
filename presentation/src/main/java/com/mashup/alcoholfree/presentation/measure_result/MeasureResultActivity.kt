package com.mashup.alcoholfree.presentation.measure_result

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mashup.alcoholfree.presentation.measure_result.model.MeasureResultState
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme

class MeasureResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AlcoholFreeAndroidTheme {
                MeasureResultScreen(
                    MeasureResultState(
                        headerStatus = "미쳤다.",
                        userName = "우진",
                        overDrinkSojuCount = 4,
                        totalDrinkCountOfCup = 25,
                        totalDrinkKcal = 132,
                        totalDrinkAlcohol = 16.9f,
                        totalDrinkTime = "3시간 20분",
                        drinkCountOfSoju = 3,
                        drinkCountOfBeer = 4,
                        drinkCountOfKaoliangju = 3,
                        drinkCountOfWine = 3,
                    ),
                )
            }
        }
    }
}
