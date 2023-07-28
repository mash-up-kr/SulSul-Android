package com.mashup.alcoholfree.presentation.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholPromiseCardState
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholTier
import com.mashup.alcoholfree.presentation.ui.home.model.HomeState
import com.mashup.alcoholfree.presentation.ui.measureresult.MeasureResultActivity
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.utils.ImmutableList
import com.mashup.alcoholfree.presentation.utils.moveToActivity

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            AlcoholFreeAndroidTheme {
                HomeScreen(
                    state = HomeState(
                        userName = "우진",
                        alcoholTier = AlcoholTier.LEVEL3,
                        cardList = ImmutableList(AlcoholPromiseCardState.sampleCardList()),
                    ),
                    onAlcoholCardClick = { moveToActivity(MeasureResultActivity::class.java) },
                )
            }
        }
    }
}
