package com.mashup.alcoholfree.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.login.LoginActivity
import com.mashup.alcoholfree.presentation.ui.measureresult.MeasureResultActivity
import com.mashup.alcoholfree.presentation.ui.measuring.MeasuringActivity
import com.mashup.alcoholfree.presentation.ui.register.RegisterTierActivity
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.ui.tiercard.TierCardInfoActivity
import com.mashup.alcoholfree.presentation.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : ComponentActivity() {
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

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
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.errorEvent.observe(this) {
            showToast(R.string.common_error)
        }
    }

    private fun navigateToRegisterTier() {
        startActivity(RegisterTierActivity.newIntent(this))
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

    private fun navigateToLogin() {
        startActivity(
            Intent(this, LoginActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP),
        )
    }
}
