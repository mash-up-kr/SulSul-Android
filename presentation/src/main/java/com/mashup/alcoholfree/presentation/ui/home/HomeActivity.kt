package com.mashup.alcoholfree.presentation.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholLevel
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholPromiseCardState
import com.mashup.alcoholfree.presentation.ui.home.model.Drink
import com.mashup.alcoholfree.presentation.ui.home.model.HomeState

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HomeScreen(
                HomeState(
                    userName = "우진",
                    alcoholLevel = AlcoholLevel.LEVEL3,
                ),
                AlcoholPromiseCardState(
                    drinks = listOf(
                        Drink("맥주", "1"),
                        Drink("와인", "2"),
                    ),
                    drankDate = "2023-08-21T04:00:00Z",
                    subTitleText = "술 좀 치네",
                ),
            )
        }
    }
}
