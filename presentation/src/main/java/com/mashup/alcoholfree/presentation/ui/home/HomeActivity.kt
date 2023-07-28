package com.mashup.alcoholfree.presentation.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.core.os.bundleOf
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mashup.alcoholfree.presentation.ui.measureresult.MeasureResultActivity
import com.mashup.alcoholfree.presentation.ui.measuring.MeasuringActivity
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.utils.moveToActivity
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
                    onAlcoholCardClick = {
                        moveToActivity(
                            MeasureResultActivity::class.java,
                            bundleOf("reportId" to it),
                        )
                    },
                    onDrinkAlcoholClick = { moveToActivity(MeasuringActivity::class.java) },
                )
            }
        }
    }

    private fun initData() = with(viewModel) {
        getUserInfo()
        getAlcoholPromiseCards()
    }
}
