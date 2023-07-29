package com.mashup.alcoholfree.presentation.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mashup.alcoholfree.presentation.ui.measureresult.MeasureResultActivity
import com.mashup.alcoholfree.presentation.ui.measuring.MeasuringActivity
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        initData()

        setContent {
            AlcoholFreeAndroidTheme {
                val state by viewModel.state.collectAsStateWithLifecycle()

                HomeScreen(
                    state = state,
                    onAlcoholCardClick = { navigateToMeasureResult(it) },
                    onDrinkAlcoholClick = { navigateToMeasure() },
                )
            }
        }
    }

    private fun initData() = with(viewModel) {
        getUserInfo()
        getAlcoholPromiseCards()
    }

    private fun navigateToMeasure() {
        startActivity(MeasuringActivity.newIntent(this))
    }

    private fun navigateToMeasureResult(reportId: String) {
        startActivity(MeasureResultActivity.newIntent(this, reportId))
    }
}
