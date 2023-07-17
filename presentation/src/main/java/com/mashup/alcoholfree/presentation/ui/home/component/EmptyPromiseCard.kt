package com.mashup.alcoholfree.presentation.ui.home.component

import androidx.compose.foundation.Image
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

@Composable
fun EmptyPromiseCard(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .clip(shape = emptyPromiseCardShape)
            .border(width = 1.dp, color = Grey300, shape = emptyPromiseCardShape)
            .paint(
                painterResource(id = R.drawable.sulsul_grain_background),
                contentScale = ContentScale.Crop,
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
            text = "아직 등록된 술 약속이 없어요",
            style = H4,
            color = Grey600,
        )
        Text(
            text = "술자리에서 마신 술을 등록해 보세요",
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