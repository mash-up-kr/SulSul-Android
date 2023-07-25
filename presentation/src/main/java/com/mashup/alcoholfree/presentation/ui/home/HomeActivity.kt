package com.mashup.alcoholfree.presentation.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholTier
import com.mashup.alcoholfree.presentation.ui.home.model.HomeState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val vieWModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vieWModel.getAlcoholPromiseCards()

        setContent {
            val cardList by vieWModel.cardList.collectAsStateWithLifecycle()

            HomeScreen(
                state = HomeState(
                    userName = "우진",
                    alcoholTier = AlcoholTier.LEVEL3,
                    cardList = cardList,
                ),
            )
        }
    }
}
