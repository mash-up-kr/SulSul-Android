package com.mashup.alcoholfree.presentation.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.component.SulSulIconStartButton
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonColor
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonSize
import com.mashup.alcoholfree.presentation.ui.home.component.AlcoholLevelCard
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholLevel
import com.mashup.alcoholfree.presentation.ui.theme.H2
import com.mashup.alcoholfree.presentation.ui.theme.H3
import com.mashup.alcoholfree.presentation.ui.theme.White

@Composable
fun HomeScreen() {
    val name = "우진"
    val alcoholLevel = AlcoholLevel.LEVEL3

    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Text(
            modifier = Modifier.padding(top = 40.dp),
            text = "${name}님은",
            style = H2,
            color = White,
        )
        AlcoholLevelCard(
            modifier = Modifier.padding(top = 8.dp),
            alcoholLevel = alcoholLevel,
        )
        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = "나의 술 약속\uD83C\uDF7E",
            style = H3,
            color = White,
        )
        /* TODO: 술 약속 카드 컴포넌트가 들어와야함 */
        Box(
            modifier = Modifier.padding(top = 16.dp),
        ) {

        }

        SulSulIconStartButton(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 35.dp, bottom = 40.dp),
            imageResId = R.drawable.ic_plus,
            content = "술 마시러 가기",
            buttonColor = SulSulButtonColor.GREY300,
            buttonSize = SulSulButtonSize.LARGE,
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
