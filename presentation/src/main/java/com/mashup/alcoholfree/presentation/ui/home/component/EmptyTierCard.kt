package com.mashup.alcoholfree.presentation.ui.home.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import com.mashup.alcoholfree.presentation.ui.component.SulSulIconEndButton
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonColor
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonSize
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.ui.theme.Grey300
import com.mashup.alcoholfree.presentation.ui.theme.Grey600
import com.mashup.alcoholfree.presentation.ui.theme.H5
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle4

private val emptyTierShape = RoundedCornerShape(16.dp)

@Composable
fun EmptyTierCard(
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(111.dp)
            .clip(shape = emptyTierShape)
            .border(width = 1.dp, color = Grey300, shape = emptyTierShape)
            .paint(
                painter = painterResource(id = R.drawable.sulsul_grain_background),
                contentScale = ContentScale.Crop,
            ),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.home_empty_tier_title),
            style = SubTitle4,
            color = Grey600
        )
        Text(
            text = stringResource(id = R.string.home_empty_tier_subtitle),
            style = H5,
            color = Grey600
        )
        SulSulIconEndButton(
            imageResId = R.drawable.ic_arrow_right,
            content = stringResource(id = R.string.home_empty_tier_button),
            buttonColor = SulSulButtonColor.TRANSPARENT,
            buttonSize = SulSulButtonSize.MIDDLE
        )
    }
}

@Preview
@Composable
fun EmptyTierCardPreview() {
    AlcoholFreeAndroidTheme {
        EmptyTierCard()
    }
}