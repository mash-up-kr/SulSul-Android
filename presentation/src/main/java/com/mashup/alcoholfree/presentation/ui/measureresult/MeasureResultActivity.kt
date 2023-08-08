package com.mashup.alcoholfree.presentation.ui.measureresult

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.getValue
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.home.HomeActivity
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MeasureResultActivity : ComponentActivity() {
    private val viewModel: MeasureResultViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val state by viewModel.state.collectAsStateWithLifecycle()

            AlcoholFreeAndroidTheme {
                MeasureResultScreen(
                    state = state,
                ) {
                    navigateToHome()
                }
            }
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.errorEvent.observe(this) {
            showToast(R.string.common_error)
        }
    }

    private fun navigateToHome() {
        startActivity(
            Intent(this, HomeActivity::class.java)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                .addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP),
        )
    }

    companion object {
        private const val REPORT_ID = "reportId"

        fun newIntent(context: Context, reportId: String): Intent {
            return Intent(context, MeasureResultActivity::class.java).apply {
                putExtra(REPORT_ID, reportId)
            }
        }
    }
}
