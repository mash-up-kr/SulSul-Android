package com.mashup.alcoholfree.presentation.ui.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.component.SulSulMiddleBadge
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulBadgeType
import com.mashup.alcoholfree.presentation.ui.home.model.TierUiModel
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.ui.theme.Grey600
import com.mashup.alcoholfree.presentation.ui.theme.Grey900
import com.mashup.alcoholfree.presentation.ui.theme.H2
import com.mashup.alcoholfree.presentation.ui.theme.H5
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle3
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle4
import com.mashup.alcoholfree.presentation.ui.theme.White

private val alcoholTierShape = RoundedCornerShape(16.dp)

@Composable
fun AlcoholTierCard(
    modifier: Modifier = Modifier,
    alcoholTier: TierUiModel,
    onClick: () -> Unit = {},
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(111.dp)
            .clip(shape = alcoholTierShape)
            .paint(
                painter = painterResource(id = R.drawable.sulsul_grain_background),
                contentScale = ContentScale.Crop,
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
                role = Role.Button,
                onClick = onClick,
            ),
    ) {
        Row(
            modifier = Modifier.padding(start = 20.dp, top = 20.dp),
            horizontalArrangement = Arrangement.Start,
        ) {
            AlcoholTierTitle(
                alcoholTier = alcoholTier,
            )
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
        ) {
            AsyncImage(
                modifier = Modifier.height(111.dp),
                model = ImageRequest
                    .Builder(LocalContext.current)
                    .data(alcoholTier.tierImageUrl)
                    .build(),
                contentDescription = null,
            )
        }
    }
}

@Composable
private fun AlcoholTierTitle(
    modifier: Modifier = Modifier,
    alcoholTier: TierUiModel,
) {
    Column(modifier = modifier) {
        Text(
            text = alcoholTier.title,
            style = H2,
            color = White,
        )
        SulSulMiddleBadge(
            modifier = Modifier.padding(top = 4.dp),
            type = SulSulBadgeType.PURPLE,
            text = alcoholTier.subTitle,
        )
    }
}

@Composable
fun EmptyTierCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(111.dp)
            .clip(shape = alcoholTierShape)
            .paint(
                painter = painterResource(id = R.drawable.sulsul_grain_background),
                contentScale = ContentScale.Crop,
            )
            .clickable { onClick() },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = stringResource(id = R.string.home_empty_tier_title),
            style = SubTitle4,
            color = Grey600,
        )
        Text(
            text = stringResource(id = R.string.home_empty_tier_subtitle),
            style = H5,
            color = Grey600,
        )
        MeasureTierLabel(modifier = Modifier.padding(top = 9.dp))
    }
}

@Composable
private fun MeasureTierLabel(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            modifier = Modifier.padding(end = 4.dp),
            text = stringResource(id = R.string.home_empty_tier_button),
            color = Grey900,
            style = SubTitle3,
        )
        Image(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = null,
        )
    }
}

@Preview
@Composable
fun AlcoholTierCardLevel1PreView() {
    AlcoholTierCard(
        alcoholTier = TierUiModel(
            subTitle = "귀엽네",
            title = "응애 술요미",
            tierImageUrl = "url",
        ),
    )
}

@Preview
@Composable
fun EmptyTierCardPreview() {
    AlcoholFreeAndroidTheme {
        EmptyTierCard()
    }
}
