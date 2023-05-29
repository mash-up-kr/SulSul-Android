package com.mashup.alcoholfree.presentation.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.theme.KakaoContainer
import com.mashup.alcoholfree.presentation.ui.theme.KakaoSymbol

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onKakaoLoginClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom,
    ) {
        Button(
            shape = RoundedCornerShape(6.dp),
            onClick = onKakaoLoginClick,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = KakaoContainer),
        ) {
            Icon(
                painter = painterResource(id = R.drawable.kakao_symbol),
                contentDescription = null,
                modifier = Modifier.size(16.dp),
            )
            Text(
                text = stringResource(R.string.kakao_login_label),
                modifier = Modifier.padding(start = 5.dp),
                color = KakaoSymbol,
            )
        }
    }
}
