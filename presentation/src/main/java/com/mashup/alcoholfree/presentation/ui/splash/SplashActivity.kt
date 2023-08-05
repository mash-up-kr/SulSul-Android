package com.mashup.alcoholfree.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.kakao.sdk.auth.AuthApiClient
import com.kakao.sdk.user.UserApiClient
import com.mashup.alcoholfree.presentation.ui.home.HomeActivity
import com.mashup.alcoholfree.presentation.ui.login.LoginActivity
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            AlcoholFreeAndroidTheme {
                SplashScreen()
            }
        }
        checkToken()
    }

    private fun checkToken() {
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
