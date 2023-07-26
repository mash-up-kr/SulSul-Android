package com.mashup.alcoholfree.presentation.ui.measuring

import androidx.compose.foundation.background
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.web.WebContent
import com.google.accompanist.web.WebViewState
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.constants.WebViewConstant
import com.mashup.alcoholfree.presentation.ui.component.SulSulBackButton
import com.mashup.alcoholfree.presentation.ui.component.SulSulLargeBadge
import com.mashup.alcoholfree.presentation.ui.component.SulSulWebView
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulBadgeType
import com.mashup.alcoholfree.presentation.ui.measuring.model.MeasuringState
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.ui.theme.BlueGradient
import com.mashup.alcoholfree.presentation.ui.theme.GrapeGradient
import com.mashup.alcoholfree.presentation.ui.theme.GreenGradient
import com.mashup.alcoholfree.presentation.ui.theme.H1
import com.mashup.alcoholfree.presentation.ui.theme.OrangeGradient
import com.mashup.alcoholfree.presentation.ui.theme.Primary100
import com.mashup.alcoholfree.presentation.ui.theme.PurpleGradient
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle2
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle3
import com.mashup.alcoholfree.presentation.ui.theme.White

private val measuringShape = RoundedCornerShape(16.dp)

@Composable
fun MeasuringScreen(
    state: MeasuringState,
    onAlcoholSelectionChanged: (Int) -> Unit = {},
    onMeasureFinishClick: () -> Unit = {},
    onBackButtonClick: () -> Unit = {},
) {
    val gradientColorList = setGradientColor(state.currentAlcoholId)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.sulsul_grain_background),
                contentScale = ContentScale.FillBounds,
            )
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(gradientColorList.first(), Color.Transparent),
                    center = Offset(100f, 2700f),
                    radius = 800f,
                ),
                shape = RectangleShape,
                alpha = 0.5f,
            ),
    )

    MeasuringBubblesContainer(
        modifier = Modifier.fillMaxSize(),
        currentAlcoholType = state.alcoholTypes[state.currentAlcoholId],
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(gradientColorList.last(), Color.Transparent),
                    center = Offset(1400f, 2800f),
                    radius = 800f,
                ),
                shape = RectangleShape,
                alpha = 0.5f,
            ),
    ) {
        SulSulBackButton(
            modifier = Modifier
                .padding(top = 8.dp, start = 16.dp)
                .align(Alignment.TopStart),
            onClick = onBackButtonClick,
        )

        Column(
            modifier = Modifier
                .padding(top = 38.dp)
                .align(Alignment.TopCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            MeasuringHeader(
                totalCount = state.totalCount,
                status = state.records,
            )

            if (state.totalCount > 0) {
                SulSulLargeBadge(
                    modifier = Modifier.padding(top = 16.dp),
                    type = SulSulBadgeType.PURPLE,
                    text = state.level,
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AlcoholSelection(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
                selectedIndex = state.currentAlcoholId,
                items = state.alcoholTypes,
                onLeftClick = {
                    if (state.currentAlcoholId > 0) {
                        onAlcoholSelectionChanged(state.currentAlcoholId - 1)
                    }
                },
                onRightClick = {
                    if (state.currentAlcoholId < state.alcoholTypes.lastIndex) {
                        onAlcoholSelectionChanged(state.currentAlcoholId + 1)
                    }
                },
            )

            MeasuringFinishButton(
                modifier = Modifier.padding(bottom = 40.dp),
                onMeasureClick = onMeasureFinishClick,
            )
        }
    }
}

private fun setGradientColor(currentAlcohol: Int): List<Color> {
    return when (currentAlcohol) {
        1 -> listOf(OrangeGradient, GrapeGradient)
        2 -> listOf(PurpleGradient, GrapeGradient)
        3 -> listOf(GreenGradient, BlueGradient)
        4 -> listOf(OrangeGradient, GreenGradient)
        else -> listOf(BlueGradient, GrapeGradient)
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
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.alcohol_cup_count, totalCount),
            style = H1,
            color = White,
        )
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = status,
            style = SubTitle3,
            color = White,
        )
    }
}

@Composable
private fun MeasuringBubblesContainer(
    modifier: Modifier = Modifier,
    currentAlcoholType: String,
) {
    SulSulWebView(
        modifier = modifier,
        state = WebViewState(WebContent.Url(WebViewConstant.WEB_FALLING_URL)),
        currentAlcoholType = currentAlcoholType,
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
                onClick = onMeasureClick,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            modifier = Modifier.padding(17.dp),
            text = stringResource(id = R.string.finish_measuring),
            style = SubTitle2,
            color = White,
        )
    }
}

@Preview
@Composable
private fun MeasuringScreenPreview() {
    AlcoholFreeAndroidTheme {
        var alcoholId by remember { mutableStateOf(0) }
        var state by remember {
            mutableStateOf(
                MeasuringState(
                    totalCount = 25,
                    records = "와인 2잔 · 소주 2잔 · 맥주 3잔",
                    level = "미쳤다",
                    currentAlcoholId = alcoholId,
                    alcoholTypes = listOf("소주", "맥주", "위스키", "와인", "고량주"),
                ),
            )
        }

        LaunchedEffect(key1 = alcoholId) {
            state = state.copy(currentAlcoholId = alcoholId)
        }

        MeasuringScreen(
            state = state,
            onAlcoholSelectionChanged = { id -> alcoholId = id },
        )
    }
}
