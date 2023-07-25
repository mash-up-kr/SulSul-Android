package com.mashup.alcoholfree.presentation.ui.measuring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mashup.alcoholfree.presentation.ui.measuring.model.MeasuringState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MeasuringActivity : ComponentActivity() {
    private val viewModel: MeasuringViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state = viewModel.state.collectAsStateWithLifecycle()

            MeasuringScreen(
                state = state.value,
                onAlcoholSelectionChanged = { viewModel.onAlcoholSelectionChanged(it) },
            )
        }

        observeViewModel()
        viewModel.loadTierSubtitles()
    }

    private fun observeViewModel() {
        viewModel.tierSubTitles.observe(this) {
            /* TODO: 알콜 양에 따라 tierBadgeTitle 변경해줘야함 */
//            viewModel.updateTierBadgeTitle()
        }
    }
}
