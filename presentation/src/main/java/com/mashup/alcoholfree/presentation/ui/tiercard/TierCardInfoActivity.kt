package com.mashup.alcoholfree.presentation.ui.tiercard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TierCardInfoActivity : ComponentActivity() {
    private val viewModel by viewModels<TierCardInfoViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            AlcoholFreeAndroidTheme {
                val state = viewModel.state.collectAsStateWithLifecycle()

                TierCardInfoScreen(
                    state = state.value,
                    onIsWebViewLoading = viewModel::updateLoading,
                    onFinishClick = { finish() },
                )
            }
        }
    }

    companion object {
        private const val DRINK_TYPE = "drinkType"
        private const val DRINK_GLASS = "drinkGlass"

        fun newIntent(context: Context, drinkType: String, drinkGlass: Int): Intent {
            return Intent(context, TierCardInfoActivity::class.java).apply {
                putExtra(DRINK_TYPE, drinkType)
                putExtra(DRINK_GLASS, drinkGlass)
            }
        }
    }
}
