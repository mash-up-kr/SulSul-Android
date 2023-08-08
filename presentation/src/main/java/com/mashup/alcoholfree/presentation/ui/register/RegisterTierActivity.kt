package com.mashup.alcoholfree.presentation.ui.register

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.utils.observeEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterTierActivity : ComponentActivity() {
    private val viewModel by viewModels<RegisterTierViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            AlcoholFreeAndroidTheme {
                val state = viewModel.state.collectAsStateWithLifecycle()

                RegisterTierScreen(
                    state = state.value,
                    onSuccess = viewModel::registerTier,
                    onIsWebViewLoading = viewModel::updateLoading,
                    onFinishClick = { finish() },
                    onValidationDialogVisibilityChanged = viewModel::updateValidationDialogVisibility,
                )
            }
        }
        observeData()
    }

    private fun observeData() {
        viewModel.successEvent.observeEvent(this) {
            finish()
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, RegisterTierActivity::class.java)
        }
    }
}
