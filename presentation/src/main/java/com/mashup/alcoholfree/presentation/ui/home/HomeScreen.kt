package com.mashup.alcoholfree.presentation.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.component.AlcoholPromiseCardView
import com.mashup.alcoholfree.presentation.ui.component.SulSulIconStartButton
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonColor
import com.mashup.alcoholfree.presentation.ui.component.model.SulSulButtonSize
import com.mashup.alcoholfree.presentation.ui.home.component.AlcoholLevelCard
import com.mashup.alcoholfree.presentation.ui.home.model.AlcoholLevel
import com.mashup.alcoholfree.presentation.ui.home.model.HomeState
import com.mashup.alcoholfree.presentation.ui.theme.H2
import com.mashup.alcoholfree.presentation.ui.theme.H3
import com.mashup.alcoholfree.presentation.ui.theme.White

@Composable
fun HomeScreen(
    state: HomeState,
) {
    Column(
        modifier = Modifier.padding(horizontal = 16.dp),
    ) {
        Text(
            modifier = Modifier.padding(top = 40.dp),
            text = stringResource(id = R.string.home_title, state.userName),
            style = H2,
            color = White,
        )
        AlcoholLevelCard(
            modifier = Modifier.padding(top = 8.dp),
            alcoholLevel = state.alcoholLevel,
        )
        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = stringResource(id = R.string.home_alcohol_appointment_text),
            style = H3,
            color = White,
        )

        AlcoholPromiseCardView(
            modifier = Modifier
                .padding(top = 16.dp)
                .weight(1f),
        )

        SulSulIconStartButton(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 35.dp, bottom = 40.dp),
            imageResId = R.drawable.ic_plus,
            content = stringResource(id = R.string.home_button_text),
            buttonColor = SulSulButtonColor.GREY300,
            buttonSize = SulSulButtonSize.LARGE,
        )
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        HomeState(
            userName = "우진",
            alcoholLevel = AlcoholLevel.LEVEL3,
        ),
    )
}
