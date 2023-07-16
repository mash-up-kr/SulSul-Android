package com.mashup.alcoholfree.presentation.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
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
    Column(
        modifier = Modifier.fillMaxSize().paint(
            painterResource(id = R.drawable.sulsul_background),
            contentScale = ContentScale.FillBounds,
        ),
        modifier = Modifier.padding(top = 120.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        LoginIntroTitle(modifier = Modifier.padding(bottom = 40.dp))
        LoginIntroImage(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 9.dp),
        )
        Spacer(modifier = Modifier.height(24.dp))
        KakaoLoginButton(
            modifier = Modifier.padding(bottom = 40.dp),
            onKakaoLoginClick = onKakaoLoginClick,
        )
    }
}

@Composable
private fun LoginIntroTitle(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            modifier = Modifier.padding(bottom = 16.dp),
            painter = painterResource(id = R.drawable.sulsul_title_label),
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
        Text(
            modifier = Modifier.padding(bottom = 16.dp),
            text = stringResource(R.string.my_alcohol_stat_intro_label),
            style = H1,
            color = White,
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
        )
    }
}

@Composable
private fun LoginIntroImage(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.fillMaxWidth(),
        painter = painterResource(id = R.drawable.img_main),
        contentDescription = null,
    )
}

@Composable
private fun KakaoLoginButton(
    modifier: Modifier = Modifier,
    onKakaoLoginClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clip(RoundedCornerShape(16.dp))
            .height(52.dp)
            .background(color = KakaoContainer)
            .clickable(
                role = Role.Button,
                onClick = onKakaoLoginClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(),
            ),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            modifier = Modifier.padding(end = 8.dp),
            painter = painterResource(id = R.drawable.ic_kakao),
            contentDescription = null,
        )
        Text(
            text = stringResource(R.string.kakao_login_label),
            style = H5,
            color = KakaoSymbol,
        )
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    AlcoholFreeAndroidTheme {
        LoginScreen(onKakaoLoginClick = {})
    }
}
