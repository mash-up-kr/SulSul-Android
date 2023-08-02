package com.mashup.alcoholfree.presentation.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.component.SulSulMiddleBadge
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulBadgeType
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholPromiseCardState
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholPromiseCardType
import com.mashup.alcoholfree.presentation.ui.home.model.DrinkUiModel
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.ui.theme.Grey300
import com.mashup.alcoholfree.presentation.ui.theme.H2
import com.mashup.alcoholfree.presentation.ui.theme.ParagraphLg
import com.mashup.alcoholfree.presentation.ui.theme.White
import com.mashup.alcoholfree.presentation.utils.ImmutableList

private val cardShape = RoundedCornerShape(16.dp)

@Composable
fun AlcoholPromiseCard(
    modifier: Modifier = Modifier,
    state: AlcoholPromiseCardState,
    onAlcoholCardClick: (String) -> Unit,
) {
    Column(
        modifier = modifier
            .clickable { onAlcoholCardClick(state.id) }
            .clip(shape = cardShape)
            .border(width = 1.dp, color = Grey300, shape = cardShape)
            .paint(
                painterResource(id = R.drawable.sulsul_grain_background),
                contentScale = ContentScale.Crop,
            )
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        state.cardType.color,
                        Color.Transparent,
                    ),
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
                    start = 32.dp,
                    end = 32.dp,
                    top = 32.dp,
                    bottom = 16.dp,
                ),
            painter = painterResource(id = state.cardType.imageResId),
            alignment = Alignment.Center,
            contentScale = ContentScale.Fit,
            contentDescription = null,
        )
        AlcoholTypeCount(
            modifier = Modifier.padding(horizontal = 32.dp),
            list = state.drinks.list,
        )
        Text(
            modifier = Modifier.padding(start = 32.dp),
            text = state.drankDate,
            style = ParagraphLg,
            color = White,
        )
        SulSulMiddleBadge(
            modifier = Modifier.padding(start = 32.dp, top = 8.dp, bottom = 32.dp),
            type = SulSulBadgeType.PURPLE,
            text = state.tier,
        )
    }
}

@Composable
private fun AlcoholTypeCount(
    modifier: Modifier = Modifier,
    list: List<DrinkUiModel>,
) {
    Row(
        modifier = modifier,
    ) {
        list.forEachIndexed { index, alcohol ->
            val text = stringResource(
                id = R.string.alcohol_record_count,
                alcohol.alcoholType,
                alcohol.glasses,
            )

            Text(
                text = if (index != list.size - 1) {
                    "$text, "
                } else {
                    text
                },
                style = H2,
                color = White,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

@Preview
@Composable
private fun AlcoholPromiseCardPreview() {
    AlcoholFreeAndroidTheme {
        AlcoholPromiseCard(
            state = AlcoholPromiseCardState(
                id = "",
                cardType = AlcoholPromiseCardType.SOJU,
                drinks = ImmutableList(
                    listOf(
                        DrinkUiModel("맥주", 1),
                        DrinkUiModel("와인", 2),
                    ),
                ),
                drankDate = "2023.08.21",
                tier = "술 좀 치네",
            ),
            onAlcoholCardClick = {},
        )
    }
}
