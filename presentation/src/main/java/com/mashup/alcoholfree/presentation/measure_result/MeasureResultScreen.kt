package com.mashup.alcoholfree.presentation.measure_result

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.measure_result.model.AlcoholType
import com.mashup.alcoholfree.presentation.measure_result.model.MeasureResultState
import com.mashup.alcoholfree.presentation.ui.theme.Grey050
import com.mashup.alcoholfree.presentation.ui.theme.Grey200
import com.mashup.alcoholfree.presentation.ui.theme.Grey300
import com.mashup.alcoholfree.presentation.ui.theme.Grey800
import com.mashup.alcoholfree.presentation.ui.theme.Grey900
import com.mashup.alcoholfree.presentation.ui.theme.H1
import com.mashup.alcoholfree.presentation.ui.theme.H3
import com.mashup.alcoholfree.presentation.ui.theme.H4
import com.mashup.alcoholfree.presentation.ui.theme.H5
import com.mashup.alcoholfree.presentation.ui.theme.SubPurple
import com.mashup.alcoholfree.presentation.ui.theme.SubPurple16
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle2
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle3
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle4
import com.mashup.alcoholfree.presentation.ui.theme.White
import com.mashup.alcoholfree.presentation.ui.theme.White40

private val rootHorizontalPadding = 16.dp

@Composable
fun MeasureResultScreen(
    state: MeasureResultState,
    onClickGoToHome: () -> Unit = {},
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier.verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        MeasureResultHeader(
            modifier = Modifier.padding(top = 56.dp),
            status = state.headerStatus,
            userName = state.userName,
            sojuCount = state.overDrinkSojuCount,
        )

        MeasureAlcoholCupCountBox(
            modifier = Modifier.padding(top = 8.dp),
            alcoholCupCount = state.totalDrinkCountOfCup,
        )

        MeasureResultInfoItems(
            modifier = Modifier.padding(
                top = 32.dp,
                start = rootHorizontalPadding,
                end = rootHorizontalPadding,
            ),
            kcal = state.totalDrinkKcal,
            alcohol = state.totalDrinkAlcohol,
            time = state.totalDrinkTime,
        )

        Divider(
            modifier = Modifier.padding(
                top = 40.dp,
                start = rootHorizontalPadding,
                end = rootHorizontalPadding,
            ),
            color = White40,
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
        )
    }

    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ) {
        MeasureResultHomeButton(onClickGoToHome)
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
private fun MeasureAlcoholCupCountBox(modifier: Modifier = Modifier, alcoholCupCount: Int) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(8.dp))
            .background(color = SubPurple16),
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
            text = stringResource(id = R.string.alcohol_cup_count, alcoholCupCount),
            style = SubTitle3,
            color = SubPurple,
        )
    }
}

@Composable
private fun MeasureResultInfoItems(
    modifier: Modifier = Modifier,
    kcal: Int,
    alcohol: Float,
    time: String,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        /* TODO: icon 변경 되어야함 */
        MeasureResultInfoItem(
            imageResId = R.drawable.clock,
            mainText = "$kcal Kcal",
            subText = stringResource(id = R.string.today_drink_kcal),
        )
        MeasureResultInfoItem(
            imageResId = R.drawable.clock,
            mainText = "${alcohol}%",
            subText = stringResource(id = R.string.average_alcohol_level),
        )
        MeasureResultInfoItem(
            imageResId = R.drawable.clock,
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
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = stringResource(id = R.string.drink_alcohol_collect_and_see), style = H3, color = White)
        MeasureResultDrinkAlcoholCupLayer(
            modifier = Modifier.padding(top = 20.dp, bottom = 125.dp),
            drinkCountOfSoju = drinkCountOfSoju,
            drinkCountOfBeer = drinkCountOfBeer,
            drinkCountOfKaoliangju = drinkCountOfKaoliangju,
            drinkCountOfWine = drinkCountOfWine,
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
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(color = Grey050),
    ) {
        MeasureResultDrinkAlcoholCupCountItem(
            modifier = Modifier.padding(vertical = 16.dp),
            alcoholType = AlcoholType.SOJU,
            drinkCount = drinkCountOfSoju,
        )

        Divider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Grey200
        )

        MeasureResultDrinkAlcoholCupCountItem(
            modifier = Modifier.padding(vertical = 16.dp),
            alcoholType = AlcoholType.BEER,
            drinkCount = drinkCountOfBeer,
        )

        Divider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Grey200
        )

        MeasureResultDrinkAlcoholCupCountItem(
            modifier = Modifier.padding(vertical = 16.dp),
            alcoholType = AlcoholType.KAOLIANGJU,
            drinkCount = drinkCountOfKaoliangju,
        )

        Divider(
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Grey200
        )

        MeasureResultDrinkAlcoholCupCountItem(
            modifier = Modifier.padding(vertical = 16.dp),
            alcoholType = AlcoholType.WINE,
            drinkCount = drinkCountOfWine,
        )
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
            text = stringResource(id = R.string.drink_type_and_count, alcoholType.title, drinkCount),
            style = H5,
            color = White,
        )

        Spacer(modifier = Modifier.height(8.dp))

        Row {
            for (i in 0 until drinkCount) {
                Image(
                    painter = painterResource(id = alcoholType.iconResId),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
private fun MeasureResultHomeButton(onClickGoToHome: () -> Unit = {}) {
    Box(
        modifier = Modifier
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
            overDrinkSojuCount = 4,
            totalDrinkCountOfCup = 25,
            totalDrinkKcal = 132,
            totalDrinkAlcohol = 16.9f,
            totalDrinkTime = "3시간 20분",
            drinkCountOfSoju = 3,
            drinkCountOfBeer = 4,
            drinkCountOfKaoliangju = 3,
            drinkCountOfWine = 3,
        )
    )
}
