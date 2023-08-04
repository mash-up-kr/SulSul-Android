package com.mashup.alcoholfree.presentation.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mashup.alcoholfree.presentation.ui.measureresult.MeasureResultActivity
import com.mashup.alcoholfree.presentation.ui.measuring.MeasuringActivity
import com.mashup.alcoholfree.presentation.ui.register.RegisterTierActivity
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.ui.tiercard.TierCardInfoActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val viewModel by viewModels<HomeViewModel>()
    private val registerTierLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                viewModel.getUserInfo()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        initData()

        setContent {
            AlcoholFreeAndroidTheme {
                val state by viewModel.state.collectAsStateWithLifecycle()

                HomeScreen(
                    state = state,
                    onEmptyTierCardClick = { navigateToRegisterTier() },
                    onAlcoholCardClick = { navigateToMeasureResult(it) },
                    onDrinkAlcoholClick = { navigateToMeasure() },
                    onTierCardClick = {
                        state.drinkLimit?.let { navigateToTierCard(it.alcoholType, it.glasses) }
                    },
                )
            }
        }
    }

    private fun initData() = with(viewModel) {
        getUserInfo()
    }

    private fun navigateToRegisterTier() {
        registerTierLauncher.launch(RegisterTierActivity.newIntent(this))
    }

    private fun navigateToMeasure() {
        startActivity(MeasuringActivity.newIntent(this))
    }

    private fun navigateToMeasureResult(reportId: String) {
        startActivity(MeasureResultActivity.newIntent(this, reportId))
    }

    private fun navigateToTierCard(drinkType: String, drinkGlass: Int) {
        startActivity(TierCardInfoActivity.newIntent(this, drinkType, drinkGlass))
    }
}
