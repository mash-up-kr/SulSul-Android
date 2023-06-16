package com.mashup.alcoholfree.presentation.ui.home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme

class HomeActivity : ComponentActivity() {
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AlcoholFreeAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    HomeScreen(
                        listOf(
                            TempAlcohol("와인", 2),
                            TempAlcohol("맥주", 1),
                        ),
                    )
                }
            }
        }
    }

    data class TempAlcohol(
        val alcohol: String,
        val amount: Int,
    )
}
