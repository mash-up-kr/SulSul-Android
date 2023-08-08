package com.mashup.alcoholfree.presentation.ui.measuring

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.measureresult.MeasureResultActivity
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.utils.observeEvent
import com.mashup.alcoholfree.presentation.utils.showToast
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MeasuringActivity : ComponentActivity() {
    private val viewModel: MeasuringViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            AlcoholFreeAndroidTheme {
                val state = viewModel.state.collectAsStateWithLifecycle()

                MeasuringScreen(
                    state = state.value,
                    onAlcoholSelectionChanged = { viewModel.updateCurrentAlcoholId(it) },
                    onValidationDialogVisibilityChanged = viewModel::updateValidationDialogVisibility,
                    onBackButtonClick = { finish() },
                    onAddBallSuccess = viewModel::addAlcoholItem,
                    onMeasureFinishClick = viewModel::createMeasureResultReport,
                    onIsWebViewLoading = viewModel::updateIsLoading,
                )
            }
        }
        observeData()
    }

    private fun observeData() {
        viewModel.createReportSuccessEvent.observeEvent(this) { reportId ->
            navigateToMeasureResult(reportId)
        }

        viewModel.errorEvent.observe(this) {
            showToast(R.string.common_error)
        }
    }

    private fun navigateToMeasureResult(reportId: String) {
        startActivity(MeasureResultActivity.newIntent(this, reportId))
        finish()
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MeasuringActivity::class.java)
        }
    }
}
