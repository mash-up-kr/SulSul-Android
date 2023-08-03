package com.mashup.alcoholfree.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.kakao.sdk.auth.AuthApiClient
import com.kakao.sdk.user.UserApiClient
import com.mashup.alcoholfree.presentation.ui.home.HomeActivity
import com.mashup.alcoholfree.presentation.ui.login.LoginActivity
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlcoholFreeAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    SplashScreen()
                }
            }
        }

        if (AuthApiClient.instance.hasToken()) {
            UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
                if (error == null && tokenInfo != null) {
                    navigateToHome()
                } else {
                    navigateToLogin()
                }
            }
        } else {
            navigateToLogin()
        }
    }

    private fun navigateToHome() {
        startActivity(
            Intent(this, HomeActivity::class.java),
        )
        finish()
    }

    private fun navigateToLogin() {
        startActivity(
            Intent(this, LoginActivity::class.java),
        )
        finish()
    }
}
