package com.mashup.alcoholfree.presentation.measure_result

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.ui.theme.Grey800
import com.mashup.alcoholfree.presentation.ui.theme.Grey900
import com.mashup.alcoholfree.presentation.ui.theme.H1
import com.mashup.alcoholfree.presentation.ui.theme.H5
import com.mashup.alcoholfree.presentation.ui.theme.SubPurple
import com.mashup.alcoholfree.presentation.ui.theme.SubPurple16
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle3
import com.mashup.alcoholfree.presentation.ui.theme.White

@Composable
fun MeasureResultScreen() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        /* TODO: 서버(?)에서 받아올 예정 */
        MeasureResultHeader(
            status = "미쳤다.",
            userName = "우진",
            sojuCount = 4,
        )

        MeasureAlcoholCupCountBox(
            modifier = Modifier.padding(top = 8.dp),
            alcoholCupCount = 25,
        )
    }
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

@Composable
fun MeasureAlcoholCupCountBox(modifier: Modifier = Modifier, alcoholCupCount: Int) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = SubPurple16)
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
            text = "총 ${alcoholCupCount}잔",
            style = SubTitle3,
            color = SubPurple,
        )
    }
}

@Preview
@Composable
fun MeasureResultScreenPreview() {
    MeasureResultScreen()
}
