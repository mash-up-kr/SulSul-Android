package com.mashup.alcoholfree.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onLoginScreenClick: () -> Unit,
    tempText: String = "",
) {
    Column(modifier = modifier) {
        Button(
            shape = RoundedCornerShape(6.dp),
            onClick = onLoginScreenClick,
            modifier = modifier,
        ) {
            Text(
                text = "로그인 화면",
            )
        }
        Text(text = tempText)
    }
}
