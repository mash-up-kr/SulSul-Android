package com.mashup.alcoholfree.presentation.ui.measuring

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MeasuringActivity : ComponentActivity() {
    private val viewModel: MeasuringViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            val state = viewModel.state.collectAsStateWithLifecycle()

            MeasuringScreen(
                state = state.value,
                onAlcoholSelectionChanged = { viewModel.updateCurrentAlcoholId(it) },
                onBackButtonClick = { finish() },
            )
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MeasuringActivity::class.java)
        }
    }
}
