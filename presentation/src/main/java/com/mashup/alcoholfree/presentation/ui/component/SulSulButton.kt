package com.mashup.alcoholfree.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonColor
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonSize
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulIconOnlyButtonSize
import com.mashup.alcoholfree.presentation.ui.theme.White

@Composable
fun SulSulDefaultButton(
    modifier: Modifier = Modifier,
    content: String,
    buttonColor: SulSulButtonColor,
    buttonSize: SulSulButtonSize,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(buttonSize.radius.dp))
            .background(color = buttonColor.color)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                role = Role.Button,
                onClick = onClick,
            ),
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = buttonSize.horizontalPadding.dp,
                vertical = buttonSize.verticalPadding.dp,
            ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = content,
                style = buttonSize.textStyle,
                color = White,
            )
        }
    }
}

@Composable
fun SulSulIconStartButton(
    modifier: Modifier = Modifier,
    imageResId: Int,
    content: String,
    buttonColor: SulSulButtonColor,
    buttonSize: SulSulButtonSize,
    onClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(buttonSize.radius.dp))
            .background(color = buttonColor.color)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                role = Role.Button,
                onClick = onClick,
            ),
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = buttonSize.horizontalPadding.dp,
                vertical = buttonSize.verticalPadding.dp,
            ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = null,
            )
            Text(
                modifier = Modifier.padding(start = buttonSize.imagePadding.dp),
                text = content,
                style = buttonSize.textStyle,
                color = White,
            )
        }
    }
}

@Composable
fun SulSulIconEndButton(
    modifier: Modifier = Modifier,
    imageResId: Int,
    content: String,
    buttonColor: SulSulButtonColor,
    buttonSize: SulSulButtonSize,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(buttonSize.radius.dp))
            .background(color = buttonColor.color)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                role = Role.Button,
                onClick = onClick,
            ),
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = buttonSize.horizontalPadding.dp,
                vertical = buttonSize.verticalPadding.dp,
            ),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = content,
                style = buttonSize.textStyle,
                color = White,
            )
            Image(
                modifier = Modifier.padding(start = buttonSize.imagePadding.dp),
                painter = painterResource(id = imageResId),
                contentDescription = null,
            )
        }
    }
}

@Composable
fun SulSulIconOnlyButton(
    modifier: Modifier = Modifier,
    imageResId: Int,
    buttonSize: SulSulButtonSize,
    buttonColor: SulSulButtonColor,
    iconOnlyButtonSize: SulSulIconOnlyButtonSize,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(buttonSize.radius.dp))
            .background(color = buttonColor.color)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                role = Role.Button,
                onClick = onClick,
            ),
    ) {
        Row(
            modifier = Modifier.padding(iconOnlyButtonSize.imagePadding.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = imageResId),
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
        imageResId = R.drawable.ic_kakao,
        buttonSize = SulSulButtonSize.MIDDLE,
        buttonColor = SulSulButtonColor.PRIMARY200,
        onClick = {},
    )
}

@Preview
@Composable
private fun SulSulIconEndButtonPreview() {
    SulSulIconEndButton(
        content = "테스트",
        imageResId = R.drawable.ic_kakao,
        buttonSize = SulSulButtonSize.LARGE,
        buttonColor = SulSulButtonColor.GREY200,
    )
}

@Preview
@Composable
private fun SulSulIconOnlyButtonPreview() {
    SulSulIconOnlyButton(
        imageResId = R.drawable.ic_kakao,
        buttonSize = SulSulButtonSize.MIDDLE,
        buttonColor = SulSulButtonColor.GREY300,
        iconOnlyButtonSize = SulSulIconOnlyButtonSize.MIDDLE,
    )
}
