package com.mashup.alcoholfree.presentation.ui.measuring

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.measure_result.model.AlcoholType
import com.mashup.alcoholfree.presentation.ui.component.SulSulLargeBadge
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulBadgeType
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.ui.theme.H1
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle3
import com.mashup.alcoholfree.presentation.ui.theme.White

@Composable
fun MeasuringScreen(
    totalCount: Int,
    records: String,
    level: String,
    currentAlcoholType: AlcoholType,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MeasuringHeader(
            modifier = Modifier.padding(top = 38.dp),
            totalCount = totalCount,
            status = records,
        )

        if (totalCount > 0) {
            SulSulLargeBadge(
                modifier = Modifier.padding(top = 16.dp),
                type = SulSulBadgeType.PURPLE,
                text = level
            )
        }

        MeasuringSelectedAlcoholBubble(
            modifier = Modifier.padding(vertical = 16.dp),
            selectedAlcoholType = currentAlcoholType
        )
    }
}

@Composable
private fun MeasuringHeader(
    modifier: Modifier = Modifier,
    totalCount: Int,
    status: String,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.alcohol_cup_count, totalCount),
            style = H1,
            color = White
        )
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = status,
            style = SubTitle3,
            color = White
        )
    }
}

@Composable
private fun MeasuringSelectedAlcoholBubble(
    modifier: Modifier = Modifier,
    selectedAlcoholType: AlcoholType
) {
    val resId = when (selectedAlcoholType) {
        AlcoholType.SOJU -> R.drawable.ic_bubble_soju
        AlcoholType.BEER -> R.drawable.ic_bubble_macju
        AlcoholType.KAOLIANGJU -> R.drawable.ic_bubble_goryanju
        AlcoholType.WINE -> R.drawable.ic_bubble_wine
    }

    Image(
        modifier = modifier,
        painter = painterResource(id = resId),
        contentDescription = null
    )
}

@Preview
@Composable
private fun MeasuringScreenPreview() {
    AlcoholFreeAndroidTheme {
        MeasuringScreen(
            totalCount = 25,
            records = "와인 2잔 · 소주 2잔 · 맥주 3잔",
            level = "미쳤다",
            currentAlcoholType = AlcoholType.SOJU,
        )
    }
}
