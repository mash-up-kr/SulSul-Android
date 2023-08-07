package com.mashup.alcoholfree.presentation.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.component.SulSulIconStartButton
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonColor
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonSize
import com.mashup.alcoholfree.presentation.ui.home.component.AlcoholPromiseCardPager
import com.mashup.alcoholfree.presentation.ui.home.component.AlcoholTierCard
import com.mashup.alcoholfree.presentation.ui.home.component.EmptyPromiseCard
import com.mashup.alcoholfree.presentation.ui.home.component.EmptyTierCard
import com.mashup.alcoholfree.presentation.ui.home.model.HomeState
import com.mashup.alcoholfree.presentation.ui.home.model.TierUiModel
import com.mashup.alcoholfree.presentation.ui.theme.GrapeGradient
import com.mashup.alcoholfree.presentation.ui.theme.H2
import com.mashup.alcoholfree.presentation.ui.theme.H3
import com.mashup.alcoholfree.presentation.ui.theme.OrangeGradient
import com.mashup.alcoholfree.presentation.ui.theme.Primary100
import com.mashup.alcoholfree.presentation.ui.theme.White
import com.mashup.alcoholfree.presentation.utils.ImmutableList

@Composable
fun HomeScreen(
    state: HomeState,
    onEmptyTierCardClick: () -> Unit,
    onAlcoholCardClick: (String) -> Unit,
    onDrinkAlcoholClick: () -> Unit,
    onTierCardClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.sulsul_grain_background),
                contentScale = ContentScale.FillBounds,
            )
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(GrapeGradient, Color.Transparent),
                    center = Offset(1400f, 1800f),
                    radius = 1000f,
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
                    colors = listOf(OrangeGradient, Color.Transparent),
                    center = Offset(200f, 800f),
                    radius = 1200f,
                ),
                shape = RectangleShape,
                alpha = 0.5f,
            ),
        contentAlignment = Alignment.TopCenter,
    ) {
        Column(
            modifier = Modifier
                .statusBarsPadding()
                .navigationBarsPadding(),
        ) {
            Text(
                modifier = Modifier.padding(top = 40.dp, start = 16.dp),
                text = stringResource(id = R.string.home_title, state.userName),
                style = H2,
                color = White,
            )

            if (state.isTierEmpty) {
                EmptyTierCard(
                    modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp),
                    onClick = onEmptyTierCardClick,
                )
            } else {
                AlcoholTierCard(
                    modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp),
                    alcoholTier = requireNotNull(state.alcoholTier),
                    onClick = onTierCardClick,
                )
            }

            Text(
                modifier = Modifier.padding(top = 24.dp, start = 16.dp),
                text = stringResource(id = R.string.home_alcohol_appointment_text),
                style = H3,
                color = White,
            )

            if (state.isCardListEmpty) {
                EmptyPromiseCard(
                    modifier = Modifier
                        .padding(
                            top = 16.dp,
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 80.dp,
                        ),
                    onAddPromiseClick = onDrinkAlcoholClick,
                )
            } else {
                AlcoholPromiseCardPager(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .weight(1f),
                    cardList = state.cardList,
                    onAlcoholCardClick = onAlcoholCardClick,
                )
            }

            SulSulIconStartButton(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 35.dp, bottom = 40.dp),
                imageResId = R.drawable.ic_plus,
                content = stringResource(id = R.string.home_button_text),
                buttonColor = SulSulButtonColor.GREY300,
                buttonSize = SulSulButtonSize.LARGE,
                onClick = onDrinkAlcoholClick,
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center),
                color = Primary100,
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        state = HomeState(
            userName = "우진",
            alcoholTier = TierUiModel(
                subTitle = "술 좀 치네",
                title = "이쯤 되면 술잘알",
                tierImageUrl = "",
            ),
            drinkLimit = null,
            cardList = ImmutableList(emptyList()),
        ),
        onEmptyTierCardClick = {},
        onAlcoholCardClick = {},
        onDrinkAlcoholClick = {},
        onTierCardClick = {},
    )
}
