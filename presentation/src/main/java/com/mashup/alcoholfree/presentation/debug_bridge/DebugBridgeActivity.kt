package com.mashup.alcoholfree.presentation.debug_bridge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mashup.alcoholfree.presentation.measure_result.MeasureResultActivity
import com.mashup.alcoholfree.presentation.ui.login.LoginActivity

class DebugBridgeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DebugBridgeScreen(
                items = listOf(
                    LoginActivity::class.java,
                    MeasureResultActivity::class.java,
                )
            )
        }
    }
}
