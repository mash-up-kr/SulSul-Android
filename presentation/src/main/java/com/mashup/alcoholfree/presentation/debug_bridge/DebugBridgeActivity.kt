package com.mashup.alcoholfree.presentation.debug_bridge

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.mashup.alcoholfree.presentation.MainActivity

class DebugBridgeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DebugBridgeScreen(
                items = listOf(
                    MainActivity::class.java,
                )
            )
        }
    }
}
