package com.mashup.alcoholfree.presentation.measure_result

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mashup.alcoholfree.presentation.ui.theme.Grey800
import com.mashup.alcoholfree.presentation.ui.theme.Grey900
import com.mashup.alcoholfree.presentation.ui.theme.H1
import com.mashup.alcoholfree.presentation.ui.theme.H5
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle3
import com.mashup.alcoholfree.presentation.ui.theme.White

@Composable
fun MeasureResultScreen() {
    /* TODO: 서버(?)에서 받아올 예정 */
    MeasureResultHeader(
        status = "미쳤다.",
        userName = "우진",
        sojuCount = 4,
    )
}

@Composable
fun MeasureResultHeader(status: String, userName: String, sojuCount: Int) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = "오늘의 주량은?", style = H5, color = Grey900)
        Text(text = status, style = H1, color = White)
        Text(
            text = "평소 ${userName}님의 주량 대비, 소주를 ${sojuCount}잔 더 마셨어요.",
            style = SubTitle3,
            color = Grey800,
        )
    }
}

@Preview
@Composable
fun MeasureResultScreenPreview() {
    MeasureResultScreen()
}
