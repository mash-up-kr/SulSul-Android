package com.mashup.alcoholfree.presentation.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import com.mashup.alcoholfree.presentation.ui.theme.Grey300
import com.mashup.alcoholfree.presentation.ui.theme.Grey700
import com.mashup.alcoholfree.presentation.ui.theme.H1
import com.mashup.alcoholfree.presentation.ui.theme.H5
import com.mashup.alcoholfree.presentation.ui.theme.KakaoContainer
import com.mashup.alcoholfree.presentation.ui.theme.KakaoSymbol
import com.mashup.alcoholfree.presentation.ui.theme.SubTitle2
import com.mashup.alcoholfree.presentation.ui.theme.White

@Composable
fun LoginScreen(
    onKakaoLoginClick: () -> Unit,
) {
    SulSulBackground()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SulSulTitle()
        SulSulIntroImage()
    }
    KakaoLoginButton(onKakaoLoginClick)
}

@Composable
fun SulSulBackground() {
    Image(
        painter = painterResource(id = R.drawable.sulsul_login_background),
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        modifier = Modifier.fillMaxSize(),
    )
}

@Composable
fun SulSulTitle() {
    Image(
        painter = painterResource(id = R.drawable.sulsul_title_label),
        contentDescription = null,
        contentScale = ContentScale.Fit,
        modifier = Modifier.padding(top = 16.dp, bottom = 16.dp),
    )
    Text(
        text = stringResource(R.string.my_alcohol_stat_intro_label),
        style = H1,
        color = White,
        modifier = Modifier.padding(bottom = 16.dp),
    )
    Text(
        text = stringResource(R.string.my_alcohol_intro_label),
        style = SubTitle2,
        color = Grey700,
    )
    Text(
        text = stringResource(R.string.measure_intro_label),
        style = SubTitle2,
        color = Grey700,
        modifier = Modifier.padding(bottom = 40.dp),
    )
}

@Composable
fun SulSulIntroImage() {
    Image(
        painter = painterResource(id = androidx.constraintlayout.widget.R.drawable.abc_btn_check_to_on_mtrl_000),
        contentDescription = null,
        modifier = Modifier
            .size(width = 300.dp, height = 400.dp)
            .background(color = Grey300)
            .padding(bottom = 24.dp),
    )
}

@Composable
fun KakaoLoginButton(onKakaoLoginClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Button(
            shape = RoundedCornerShape(16.dp),
            onClick = onKakaoLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 9.dp, vertical = 16.dp)
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = KakaoContainer),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.kakao_symbol),
                contentDescription = null,
                modifier = Modifier
                    .padding(end = 9.dp)
                    .size(height = 16.dp, width = 17.5.dp),
            )
            Text(
                text = stringResource(R.string.kakao_login_label),
                style = H5,
                color = KakaoSymbol,
            )
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    AlcoholFreeAndroidTheme {
        LoginScreen(onKakaoLoginClick = {})
    }
}
