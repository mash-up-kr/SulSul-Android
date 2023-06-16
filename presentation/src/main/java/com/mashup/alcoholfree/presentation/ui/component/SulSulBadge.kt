package com.mashup.alcoholfree.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulBadgeType
import com.mashup.alcoholfree.presentation.ui.theme.Primary200
import com.mashup.alcoholfree.presentation.ui.theme.Primary200Transparent16
import com.mashup.alcoholfree.presentation.ui.theme.SubPurple
import com.mashup.alcoholfree.presentation.ui.theme.SubPurpleTransparent16
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle3

private val sulSulBadgeRadius = 8.dp

@Composable
fun SulSulLargeBadge(
    modifier: Modifier = Modifier,
    type: SulSulBadgeType,
    text: String,
) {
    val (badgeColor, textColor) = when (type) {
        SulSulBadgeType.PURPLE -> SubPurpleTransparent16 to SubPurple
        SulSulBadgeType.ORANGE -> Primary200Transparent16 to Primary200
    }

    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(sulSulBadgeRadius))
            .background(color = badgeColor),
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
            text = text,
            style = SubTitle3,
            color = textColor,
        )
    }
}

@Composable
fun SulSulMiddleBadge(
    modifier: Modifier = Modifier,
    type: SulSulBadgeType,
    text: String,
) {
    val (badgeColor, textColor) = when (type) {
        SulSulBadgeType.PURPLE -> SubPurpleTransparent16 to SubPurple
        SulSulBadgeType.ORANGE -> Primary200Transparent16 to Primary200
    }

    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(sulSulBadgeRadius))
            .background(color = badgeColor),
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp),
            text = text,
            style = SubTitle3,
            color = textColor,
        )
    }
}

@Preview
@Composable
private fun SulSulLargePurpleBadgePreview() {
    SulSulLargeBadge(
        type = SulSulBadgeType.PURPLE,
        text = "BADGE"
    )
}

@Preview
@Composable
private fun SulSulLargeOrangeBadgePreview() {
    SulSulLargeBadge(
        type = SulSulBadgeType.ORANGE,
        text = "BADGE"
    )
}

@Preview
@Composable
private fun SulSulMiddlePurpleBadgePreview() {
    SulSulMiddleBadge(
        type = SulSulBadgeType.PURPLE,
        text = "BADGE"
    )
}

@Preview
@Composable
private fun SulSulMiddleOrangeBadgePreview() {
    SulSulMiddleBadge(
        type = SulSulBadgeType.ORANGE,
        text = "BADGE"
    )
}
