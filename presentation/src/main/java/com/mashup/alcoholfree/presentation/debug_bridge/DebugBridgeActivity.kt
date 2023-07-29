package com.mashup.alcoholfree.presentation.debug_bridge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mashup.alcoholfree.presentation.ui.register.RegisterTierActivity
import com.mashup.alcoholfree.presentation.ui.measureresult.MeasureResultActivity
import com.mashup.alcoholfree.presentation.ui.home.HomeActivity
import com.mashup.alcoholfree.presentation.ui.login.LoginActivity
import com.mashup.alcoholfree.presentation.ui.measuring.MeasuringActivity

class DebugBridgeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DebugBridgeScreen(
                items = listOf(
                    LoginActivity::class.java,
                    MeasureResultActivity::class.java,
                    MeasuringActivity::class.java,
                    HomeActivity::class.java,
                    RegisterTierActivity::class.java,
                )
            )
        }
    }
}
