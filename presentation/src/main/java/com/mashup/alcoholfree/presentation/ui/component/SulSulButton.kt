package com.mashup.alcoholfree.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonColor
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonSize
import com.mashup.alcoholfree.presentation.ui.theme.White

@Composable
fun SulSulDefaultButton(
    modifier: Modifier = Modifier,
    content: String,
    buttonColor: SulSulButtonColor,
    buttonSize: SulSulButtonSize,
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(buttonSize.radius.dp))
            .background(color = buttonColor.color),
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(
                horizontal = buttonSize.horizontalPadding.dp,
                vertical = buttonSize.verticalPadding.dp,
            ),
        ) {
            Text(
                text = content,
                style = buttonSize.textSize,
                color = White,
            )
        }
    }
}

@Composable
fun SulSulIconStartButton(
    modifier: Modifier = Modifier,
    imgSrc: Int,
    content: String,
    buttonColor: SulSulButtonColor,
    buttonSize: SulSulButtonSize,
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(buttonSize.radius.dp))
            .background(color = buttonColor.color),
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(
                horizontal = buttonSize.horizontalPadding.dp,
                vertical = buttonSize.verticalPadding.dp,
            ),
        ) {
            Image(
                painter = painterResource(id = imgSrc),
                contentDescription = null,
            )
            Text(
                text = content,
                modifier = modifier.padding(start = buttonSize.imagePadding.dp),
                style = buttonSize.textSize,
                color = White,
            )
        }
    }
}

@Composable
fun SulSulIconEndButton(
    modifier: Modifier = Modifier,
    imgSrc: Int,
    content: String,
    buttonColor: SulSulButtonColor,
    buttonSize: SulSulButtonSize,
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(buttonSize.radius.dp))
            .background(color = buttonColor.color),
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(
                horizontal = buttonSize.horizontalPadding.dp,
                vertical = buttonSize.verticalPadding.dp,
            ),
        ) {
            Text(
                text = content,
                style = buttonSize.textSize,
                color = White,
            )
            Image(
                painter = painterResource(id = imgSrc),
                modifier = modifier.padding(start = buttonSize.imagePadding.dp),
                contentDescription = null,
            )
        }
    }
}

@Composable
fun SulSulIconOnlyButton(
    modifier: Modifier = Modifier,
    imgSrc: Int,
    buttonSize: SulSulButtonSize,
    buttonColor: SulSulButtonColor,
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(buttonSize.radius.dp))
            .background(color = buttonColor.color),
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.padding(buttonSize.singleImagePadding.dp),
        ) {
            Image(
                painter = painterResource(id = imgSrc),
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
private fun SulSulDefaultButtonPreview() {
    SulSulDefaultButton(
        content = "테스트",
        buttonColor = SulSulButtonColor.PRIMARY100,
        buttonSize = SulSulButtonSize.SMALL,
    )
}

@Preview
@Composable
private fun SulSulIconStartButtonPreview() {
    SulSulIconStartButton(
        content = "테스트",
        imgSrc = R.drawable.kakao_symbol,
        buttonSize = SulSulButtonSize.MIDDLE,
        buttonColor = SulSulButtonColor.PRIMARY200,
    )
}

@Preview
@Composable
private fun SulSulIconEndButtonPreview() {
    SulSulIconEndButton(
        content = "테스트",
        imgSrc = R.drawable.kakao_symbol,
        buttonSize = SulSulButtonSize.LARGE,
        buttonColor = SulSulButtonColor.GREY200,
    )
}

@Preview
@Composable
private fun SulSulIconOnlyButtonPreview() {
    SulSulIconOnlyButton(
        imgSrc = R.drawable.kakao_symbol,
        buttonSize = SulSulButtonSize.MIDDLE,
        buttonColor = SulSulButtonColor.GREY300,
    )
}
