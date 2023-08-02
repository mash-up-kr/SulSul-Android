package com.mashup.alcoholfree.presentation.ui.measureresult

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.component.SulSulLargeBadge
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulBadgeType
import com.mashup.alcoholfree.presentation.ui.measureresult.model.AlcoholType
import com.mashup.alcoholfree.presentation.ui.measureresult.model.MeasureResultState
import com.mashup.alcoholfree.presentation.ui.theme.BlueGradient
import com.mashup.alcoholfree.presentation.ui.theme.GreenGradient
import com.mashup.alcoholfree.presentation.ui.theme.Grey050
import com.mashup.alcoholfree.presentation.ui.theme.Grey200
import com.mashup.alcoholfree.presentation.ui.theme.Grey300
import com.mashup.alcoholfree.presentation.ui.theme.Grey700
import com.mashup.alcoholfree.presentation.ui.theme.Grey800
import com.mashup.alcoholfree.presentation.ui.theme.Grey900
import com.mashup.alcoholfree.presentation.ui.theme.H1
import com.mashup.alcoholfree.presentation.ui.theme.H3
import com.mashup.alcoholfree.presentation.ui.theme.H4
import com.mashup.alcoholfree.presentation.ui.theme.H5
import com.mashup.alcoholfree.presentation.ui.theme.PurpleGradient
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle2
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle3
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle4
import com.mashup.alcoholfree.presentation.ui.theme.White
import com.mashup.alcoholfree.presentation.ui.theme.WhiteTransparent32

private val rootHorizontalPadding = 16.dp

@Composable
fun MeasureResultScreen(
    state: MeasureResultState,
    onClickGoToHome: () -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.sulsul_grain_background),
                contentScale = ContentScale.FillBounds,
            )
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(PurpleGradient, Color.Transparent),
                    center = Offset(100f, 1700f),
                    radius = 1300f,
                ),
                shape = RectangleShape,
                alpha = 0.5f,
            ),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(GreenGradient, Color.Transparent),
                    center = Offset(1500f, 1900f),
                    radius = 700f,
                ),
                shape = RectangleShape,
                alpha = 0.5f,
            ),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(BlueGradient, Color.Transparent),
                    center = Offset(200f, 2800f),
                    radius = 900f,
                ),
                shape = RectangleShape,
                alpha = 0.5f,
            ),
    ) {
        MeasureResultContent(state = state)
        MeasureResultHomeButton(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            onClickGoToHome = onClickGoToHome,
        )
    }
}

@Composable
private fun MeasureResultContent(state: MeasureResultState) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MeasureResultHeader(
            modifier = Modifier.padding(top = 56.dp),
            status = state.headerStatus,
            userName = state.userName,
            sojuCount = state.extraGlasses,
        )

        SulSulLargeBadge(
            modifier = Modifier.padding(top = 8.dp),
            type = SulSulBadgeType.PURPLE,
            text = stringResource(id = R.string.alcohol_cup_count, state.totalDrinkCountOfCup),
        )

        MeasureResultInfoItems(
            modifier = Modifier.padding(
                top = 32.dp,
                start = rootHorizontalPadding,
                end = rootHorizontalPadding,
            ),
            kcal = state.totalDrinkKcal,
            alcohol = state.averageAlcoholPercent,
            time = state.totalDrinkTime,
        )

        Divider(
            modifier = Modifier.padding(
                top = 40.dp,
                start = rootHorizontalPadding,
                end = rootHorizontalPadding,
            ),
            color = WhiteTransparent32,
        )

        MeasureResultDrinkAlcoholCollectAndSeeLayer(
            modifier = Modifier.padding(
                top = 40.dp,
                start = rootHorizontalPadding,
                end = rootHorizontalPadding,
            ),
            drinkCountOfSoju = state.drinkCountOfSoju,
            drinkCountOfBeer = state.drinkCountOfBeer,
            drinkCountOfKaoliangju = state.drinkCountOfKaoliangju,
            drinkCountOfWine = state.drinkCountOfWine,
            drinkCountOfWhisky = state.drinkCountOfWhisky,
        )
    }
}

@Composable
private fun MeasureResultHeader(
    modifier: Modifier = Modifier,
    status: String,
    userName: String,
    sojuCount: Int,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(text = stringResource(id = R.string.measure_result_title), style = H5, color = Grey900)
        Text(text = status, style = H1, color = White)
        Text(
            text = stringResource(id = R.string.measure_result_sub_title_2, userName, sojuCount),
            style = SubTitle3,
            color = Grey800,
        )
    }
}

@Composable
private fun MeasureResultInfoItems(
    modifier: Modifier = Modifier,
    kcal: Int,
    alcohol: Double,
    time: String,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        MeasureResultInfoItem(
            imageResId = R.drawable.ic_kcal,
            mainText = "$kcal Kcal",
            subText = stringResource(id = R.string.today_drink_kcal),
        )
        MeasureResultInfoItem(
            imageResId = R.drawable.ic_alcohol,
            mainText = "$alcohol%",
            subText = stringResource(id = R.string.average_alcohol_level),
        )
        MeasureResultInfoItem(
            imageResId = R.drawable.ic_clock,
            mainText = time,
            subText = stringResource(id = R.string.drink_time),
        )
    }
}

@Composable
private fun MeasureResultInfoItem(
    imageResId: Int,
    mainText: String,
    subText: String,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = imageResId), contentDescription = null)
        Text(text = mainText, style = H4, color = White)
        Text(text = subText, style = SubTitle4, color = Grey900)
    }
}

@Composable
private fun MeasureResultDrinkAlcoholCollectAndSeeLayer(
    modifier: Modifier = Modifier,
    drinkCountOfSoju: Int,
    drinkCountOfBeer: Int,
    drinkCountOfKaoliangju: Int,
    drinkCountOfWine: Int,
    drinkCountOfWhisky: Int,
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(id = R.string.drink_alcohol_collect_and_see),
            style = H3,
            color = White,
        )
        MeasureResultDrinkAlcoholCupLayer(
            modifier = Modifier.padding(top = 20.dp, bottom = 125.dp),
            drinkCountOfSoju = drinkCountOfSoju,
            drinkCountOfBeer = drinkCountOfBeer,
            drinkCountOfKaoliangju = drinkCountOfKaoliangju,
            drinkCountOfWine = drinkCountOfWine,
            drinkCountOfWhisky = drinkCountOfWhisky,
        )
    }
}

@Composable
private fun MeasureResultDrinkAlcoholCupLayer(
    modifier: Modifier = Modifier,
    drinkCountOfSoju: Int,
    drinkCountOfBeer: Int,
    drinkCountOfKaoliangju: Int,
    drinkCountOfWine: Int,
    drinkCountOfWhisky: Int,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = Grey050),
    ) {
        val zero = 0
        if (drinkCountOfSoju > zero) {
            MeasureResultDrinkAlcoholCupCountItem(
                modifier = Modifier.padding(vertical = 16.dp),
                alcoholType = AlcoholType.SOJU,
                drinkCount = drinkCountOfSoju,
            )

            Divider(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = Grey200,
            )
        }

        if (drinkCountOfBeer > zero) {
            MeasureResultDrinkAlcoholCupCountItem(
                modifier = Modifier.padding(vertical = 16.dp),
                alcoholType = AlcoholType.BEER,
                drinkCount = drinkCountOfBeer,
            )

            Divider(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = Grey200,
            )
        }

        if (drinkCountOfKaoliangju > zero) {
            MeasureResultDrinkAlcoholCupCountItem(
                modifier = Modifier.padding(vertical = 16.dp),
                alcoholType = AlcoholType.KAOLIANGJU,
                drinkCount = drinkCountOfKaoliangju,
            )

            Divider(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = Grey200,
            )
        }

        if (drinkCountOfWine > zero) {
            MeasureResultDrinkAlcoholCupCountItem(
                modifier = Modifier.padding(vertical = 16.dp),
                alcoholType = AlcoholType.WINE,
                drinkCount = drinkCountOfWine,
            )

            Divider(
                modifier = Modifier.padding(horizontal = 16.dp),
                color = Grey200,
            )
        }

        if (drinkCountOfKaoliangju > zero) {
            MeasureResultDrinkAlcoholCupCountItem(
                modifier = Modifier.padding(vertical = 16.dp),
                alcoholType = AlcoholType.WHISKY,
                drinkCount = drinkCountOfWhisky,
            )
        }
    }
}

@Composable
private fun MeasureResultDrinkAlcoholCupCountItem(
    modifier: Modifier = Modifier,
    alcoholType: AlcoholType,
    drinkCount: Int,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(
                id = R.string.drink_type_and_count,
                alcoholType.title,
                drinkCount,
            ),
            style = H5,
            color = White,
        )

        Spacer(modifier = Modifier.height(8.dp))

        MeasureResultDrinkAlcoholCups(
            alcoholIconResId = alcoholType.iconResId,
            drinkCount = drinkCount,
        )
    }
}

@Composable
private fun MeasureResultDrinkAlcoholCups(
    alcoholIconResId: Int,
    drinkCount: Int,
) {
    val maxCountToDisplay = 4

    Row(verticalAlignment = Alignment.CenterVertically) {
        for (i in 0 until drinkCount.coerceAtMost(maxCountToDisplay)) {
            Image(
                painter = painterResource(id = alcoholIconResId),
                contentDescription = null,
            )
        }

        if (drinkCount > maxCountToDisplay) {
            Text(
                modifier = Modifier.width(52.dp),
                text = "+${drinkCount - maxCountToDisplay}",
                style = H4,
                color = Grey700,
                textAlign = TextAlign.Center,
            )
        }
    }
}

@Composable
private fun MeasureResultHomeButton(
    modifier: Modifier = Modifier,
    onClickGoToHome: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = rootHorizontalPadding, end = rootHorizontalPadding, bottom = 40.dp)
            .clip(RoundedCornerShape(16.dp))
            .height(52.dp)
            .background(color = Grey300)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                role = Role.Button,
                onClick = onClickGoToHome,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = stringResource(id = R.string.go_to_home), style = SubTitle2, color = White)
    }
}

@Preview
@Composable
private fun MeasureResultScreenPreview() {
    MeasureResultScreen(
        MeasureResultState(
            headerStatus = "미쳤다.",
            userName = "우진",
            extraGlasses = 4,
            totalDrinkCountOfCup = 25,
            totalDrinkKcal = 132,
            totalDrinkTime = "3시간 20분",
            drinkCountOfSoju = 999,
            drinkCountOfBeer = 0,
            drinkCountOfKaoliangju = 3,
            drinkCountOfWine = 3,
            drinkCountOfWhisky = 4,
            averageAlcoholPercent = 0.0,
        ),
    )
}
