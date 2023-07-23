package com.mashup.alcoholfree.presentation.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholPromiseCardState
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholTier
import com.mashup.alcoholfree.presentation.ui.home.model.HomeState
import com.mashup.alcoholfree.presentation.utils.ImmutableList

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HomeScreen(
                state = HomeState(
                    userName = "우진",
                    alcoholTier = AlcoholTier.LEVEL3,
                    cardList = ImmutableList(AlcoholPromiseCardState.sampleCardList()),
                ),
            )
        }
    }
}
