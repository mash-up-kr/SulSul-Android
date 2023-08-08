package com.mashup.alcoholfree.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.kakao.sdk.auth.AuthApiClient
import com.kakao.sdk.user.UserApiClient
import com.mashup.alcoholfree.presentation.R
import com.mashup.alcoholfree.presentation.ui.home.HomeActivity
import com.mashup.alcoholfree.presentation.ui.login.LoginActivity
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : ComponentActivity() {
    private val viewModel: SplashViewModel by viewModels()

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
        observeAddAccessToken()
    }

    private fun checkToken() {
        if (AuthApiClient.instance.hasToken()) {
            UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
                if (error == null && tokenInfo != null) {
                    addAccessToken()
                } else {
                    navigateToLogin()
                }
            }
        } else {
            navigateToLogin()
        }
    }

    private fun addAccessToken() {
        if (!viewModel.checkAccessToken()) {
            Toast
                .makeText(this, getString(R.string.login_info_messge), Toast.LENGTH_SHORT)
                .show()
            navigateToLogin()
        }
    }

    private fun observeAddAccessToken() {
        viewModel.addTokenEvent.observe(this) {
            navigateToHome()
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
