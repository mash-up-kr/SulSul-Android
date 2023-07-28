package com.mashup.alcoholfree.presentation.ui.measureresult

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import com.mashup.alcoholfree.presentation.ui.measureresult.model.MeasureResultState
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MeasureResultActivity : ComponentActivity() {
    private val viewModel: MeasureResultViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

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
        viewModel.createMeasureResultReport()
    }
}
