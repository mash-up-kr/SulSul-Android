package com.mashup.alcoholfree.presentation.measure_result

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme

class MeasureResultActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AlcoholFreeAndroidTheme {
                MeasureResultScreen()
            }
        }
    }
}
