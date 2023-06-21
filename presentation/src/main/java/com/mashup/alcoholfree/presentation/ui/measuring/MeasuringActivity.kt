package com.mashup.alcoholfree.presentation.ui.measuring

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.mashup.alcoholfree.presentation.ui.measuring.model.MeasuringState

class MeasuringActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var alcoholId by remember { mutableStateOf(0) }
            var state by remember {
                mutableStateOf(
                    MeasuringState(
                        totalCount = 25,
                        records = "와인 2잔 · 소주 2잔 · 맥주 3잔",
                        level = "미쳤다",
                        currentAlcoholId = alcoholId,
                        alcoholTypes = listOf("소주", "맥주", "위스키", "와인", "고량주"),
                    )
                )
            }

            LaunchedEffect(key1 = alcoholId) {
                state = state.copy(currentAlcoholId = alcoholId)
            }

            MeasuringScreen(
                state = state,
                onAlcoholSelectionChanged = { alcoholId = it },
            )
        }
    }
}
