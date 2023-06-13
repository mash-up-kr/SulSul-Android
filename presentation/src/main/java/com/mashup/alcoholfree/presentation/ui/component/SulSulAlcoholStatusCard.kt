package com.mashup.alcoholfree.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulAlcoholLevel
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulBadgeType

@Composable
fun SulSulAlcoholLevelCard(
    modifier: Modifier = Modifier,
    alcoholLevel: SulSulAlcoholLevel,
) {
    /* TODO: grainy background 적용해야함 */
    Row(
        modifier = modifier.width(328.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        SulSulAlcoholLevelTitle(
            modifier = Modifier.padding(start = 20.dp, top = 20.dp),
            alcoholLevel = alcoholLevel,
        )
        Image(painter = painterResource(id = alcoholLevel.imageResId), contentDescription = null)
    }
}

@Composable
fun SulSulAlcoholLevelTitle(
    modifier: Modifier = Modifier,
    alcoholLevel: SulSulAlcoholLevel,
) {
    Column(modifier = modifier) {
        Text(text = alcoholLevel.title)
        SulSulMiddleBadge(
            modifier = Modifier.padding(top = 4.dp),
            type = SulSulBadgeType.PURPLE,
            text = alcoholLevel.badgeText,
        )
    }
}

@Preview
@Composable
fun SulSulAlcoholLevelCardLevel1PreView() {
    SulSulAlcoholLevelCard(alcoholLevel = SulSulAlcoholLevel.LEVEL1)
}

@Preview
@Composable
fun SulSulAlcoholLevelCardLevel2PreView() {
    SulSulAlcoholLevelCard(alcoholLevel = SulSulAlcoholLevel.LEVEL2)
}

@Preview
@Composable
fun SulSulAlcoholLevelCardLevel3PreView() {
    SulSulAlcoholLevelCard(alcoholLevel = SulSulAlcoholLevel.LEVEL3)
}

@Preview
@Composable
fun SulSulAlcoholLevelCardLevel4PreView() {
    SulSulAlcoholLevelCard(alcoholLevel = SulSulAlcoholLevel.LEVEL4)
}

@Preview
@Composable
fun SulSulAlcoholLevelCardLevel5PreView() {
    SulSulAlcoholLevelCard(alcoholLevel = SulSulAlcoholLevel.LEVEL5)
}

@Preview
@Composable
fun SulSulAlcoholLevelCardLevel6PreView() {
    SulSulAlcoholLevelCard(alcoholLevel = SulSulAlcoholLevel.LEVEL6)
}
