package com.mashup.alcoholfree.presentation.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.component.SulSulIconStartButton
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonColor
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonSize
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.ui.theme.Grey300
import com.mashup.alcoholfree.presentation.ui.theme.Grey600
import com.mashup.alcoholfree.presentation.ui.theme.H4
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle3

private val emptyPromiseCardShape = RoundedCornerShape(16.dp)
private val emptyGradient = Color(0x33747474)

@Composable
fun EmptyPromiseCard(
    modifier: Modifier = Modifier,
    onAddPromiseClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .clip(shape = emptyPromiseCardShape)
            .border(width = 1.dp, color = Grey300, shape = emptyPromiseCardShape)
            .paint(
                painterResource(id = R.drawable.sulsul_grain_background),
                contentScale = ContentScale.Crop,
            )
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(emptyGradient, Color.Transparent),
                    center = Offset(500f, 1300f),
                    radius = 800f,
                ),
                shape = RectangleShape,
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_empty_promise),
            contentDescription = null,
        )
        Text(
            modifier = Modifier.padding(top = 32.dp),
            text = stringResource(id = R.string.home_empty_promise_title),
            style = H4,
            color = Grey600,
        )
        Text(
            text = stringResource(id = R.string.home_empty_promise_subtitle),
            style = SubTitle3,
            color = Grey600,
        )
        SulSulIconStartButton(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 35.dp),
            imageResId = R.drawable.ic_plus,
            content = stringResource(id = R.string.home_button_text),
            buttonColor = SulSulButtonColor.GREY300,
            buttonSize = SulSulButtonSize.LARGE,
        )
    }
}

@Preview
@Composable
fun EmptyPromiseCardPreview() {
    AlcoholFreeAndroidTheme {
        EmptyPromiseCard(modifier = Modifier.fillMaxWidth())
    }
}