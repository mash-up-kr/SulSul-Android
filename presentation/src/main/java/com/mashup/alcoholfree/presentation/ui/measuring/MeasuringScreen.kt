package com.mashup.alcoholfree.presentation.ui.measuring

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.component.SulSulBackButton
import com.mashup.alcoholfree.presentation.ui.component.SulSulLargeBadge
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulBadgeType
import com.mashup.alcoholfree.presentation.ui.measuring.model.AlcoholBubbleType
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.ui.theme.Grey100
import com.mashup.alcoholfree.presentation.ui.theme.Grey300
import com.mashup.alcoholfree.presentation.ui.theme.Grey800
import com.mashup.alcoholfree.presentation.ui.theme.H1
import com.mashup.alcoholfree.presentation.ui.theme.Primary100
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle2
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle3
import com.mashup.alcoholfree.presentation.ui.theme.White

private val measuringShape = RoundedCornerShape(16.dp)

@Composable
fun MeasuringScreen(
    totalCount: Int,
    records: String,
    level: String,
    currentAlcoholType: AlcoholBubbleType,
    onMeasureFinishClick: () -> Unit,
    onBackButtonClick: () -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
    ) {
        SulSulBackButton(
            modifier = Modifier
                .padding(top = 8.dp, start = 16.dp)
                .align(Alignment.TopStart),
            onClick = onBackButtonClick
        )

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
                bubbleResId = currentAlcoholType.iconResId
            )

            MeasuringBubblesContainer(
                modifier = Modifier.weight(1f),
            )

            MeasuringAlcoholSelection(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            )

            MeasuringFinishButton(
                modifier = Modifier.padding(bottom = 40.dp),
                onMeasureClick = onMeasureFinishClick
            )
        }
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
private fun MeasuringAlcoholSelection(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(measuringShape)
            .background(color = Grey100)
            .border(width = 1.dp, color = Grey300, shape = measuringShape),
        contentAlignment = Alignment.Center,
    ) {
        /* TODO: 주종 선택 컴포넌트 */
        Text(
            modifier = Modifier.padding(vertical = 8.dp),
            text = stringResource(id = R.string.alcohol_type_selection),
            style = SubTitle3,
            color = Grey800
        )
    }
}

@Composable
private fun MeasuringSelectedAlcoholBubble(
    modifier: Modifier = Modifier,
    bubbleResId: Int
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = bubbleResId),
        contentDescription = null
    )
}

@Composable
private fun MeasuringBubblesContainer(
    modifier: Modifier = Modifier,
) {
    /* TODO: 애니메이션 같은 거.. ㅎ */
    Image(
        modifier = modifier,
        painter = painterResource(id = R.drawable.kakao_symbol),
        contentDescription = null
    )
}

@Composable
private fun MeasuringFinishButton(
    modifier: Modifier = Modifier,
    onMeasureClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(measuringShape)
            .background(color = Primary100)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                role = Role.Button,
                onClick = onMeasureClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(17.dp),
            text = stringResource(id = R.string.finish_measuring),
            style = SubTitle2,
            color = White
        )
    }
}

@Preview
@Composable
private fun MeasuringScreenPreview() {
    AlcoholFreeAndroidTheme {
        MeasuringScreen(
            totalCount = 25,
            records = "와인 2잔 · 소주 2잔 · 맥주 3잔",
            level = "미쳤다",
            currentAlcoholType = AlcoholBubbleType.SOJU,
            onMeasureFinishClick = {},
            onBackButtonClick = {}
        )
    }
}
