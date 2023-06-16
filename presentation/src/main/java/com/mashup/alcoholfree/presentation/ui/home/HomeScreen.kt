package com.mashup.alcoholfree.presentation.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.component.SulSulMiddleBadge
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulBadgeType
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulPromiseCardAlcohol
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.ui.theme.FakeWhiteGradient
import com.mashup.alcoholfree.presentation.ui.theme.H2
import com.mashup.alcoholfree.presentation.ui.theme.ParagraphLg
import com.mashup.alcoholfree.presentation.ui.theme.White

@Composable
fun HomeScreen(
    list: List<HomeActivity.TempAlcohol>,
) {
    AlcoholPromiseCard(
        modifier = Modifier
            .padding(horizontal = 22.dp, vertical = 120.dp),
        alcohol = SulSulPromiseCardAlcohol.WINE,
        list = list,
    )
}

@Composable
private fun AlcoholPromiseCard(
    modifier: Modifier = Modifier,
    alcohol: SulSulPromiseCardAlcohol,
    list: List<HomeActivity.TempAlcohol>,
) {
    Column(
        modifier = modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .paint(
                painterResource(id = R.drawable.sulsul_background),
                contentScale = ContentScale.Crop,
            )
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(alcohol.color, FakeWhiteGradient),
                    center = Offset(500f, 1300f),
                    radius = 800f,
                ),
                shape = RectangleShape,
            ),
    ) {
        Image(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .padding(
                    start = 31.dp,
                    end = 31.dp,
                    top = 32.dp,
                    bottom = 16.dp,
                ),
            painter = painterResource(id = alcohol.imageResId),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds,
            contentDescription = null,
        )
        AlcoholTypeCount(
            modifier = Modifier.padding(start = 32.dp),
            list = list,
        )
        Text(
            modifier = Modifier.padding(start = 32.dp),
            text = "2013.12.20",
            style = ParagraphLg,
            color = White,
        )
        SulSulMiddleBadge(
            modifier = Modifier.padding(start = 32.dp, top = 8.dp, bottom = 32.dp),
            type = SulSulBadgeType.PURPLE,
            text = "술 좀 치네",
        )
    }
}

@Composable
private fun AlcoholTypeCount(
    modifier: Modifier = Modifier,
    list: List<HomeActivity.TempAlcohol>,
) {
    Row(
        modifier = modifier.horizontalScroll(rememberScrollState()),
    ) {
        list.forEachIndexed { index, alcohol ->
            val text = stringResource(
                id = R.string.alcohol_record_count,
                alcohol.alcohol,
                alcohol.amount,
            )

            Text(
                text = if (index != list.size - 1) {
                    "$text, "
                } else {
                    text
                },
                style = H2,
                color = White,
            )
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    AlcoholFreeAndroidTheme {
        HomeScreen(
            listOf(
                HomeActivity.TempAlcohol("맥주", 1),
                HomeActivity.TempAlcohol("와인", 2),
            ),
        )
    }
}
