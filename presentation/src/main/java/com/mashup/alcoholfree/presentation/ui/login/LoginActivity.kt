package com.mashup.alcoholfree.presentation.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.kakao.sdk.auth.AuthApiClient
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import com.mashup.alcoholfree.presentation.ui.home.HomeActivity
import com.mashup.alcoholfree.presentation.ui.theme.AlcoholFreeAndroidTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        var isValidate = true
        if (AuthApiClient.instance.hasToken()) {
            UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
                if (error == null && tokenInfo != null) {
                    navigateToHome()
                } else {
                    isValidate = false
                }
            }
        } else {
            isValidate = false
        }

        super.onCreate(savedInstanceState)
        Log.d("Kakao KeyHash : ", getKakaoKeyHash())
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            AlcoholFreeAndroidTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    if (!isValidate) {
                        LoginScreen(
                            onKakaoLoginClick = { kakaoLoginClick() },
                        )
                    }
                }
            }
        }
    }

    private fun kakaoLoginClick() {
        with(UserApiClient.instance) {
            if (isKakaoTalkLoginAvailable(this@LoginActivity)) {
                loginWithKakaoTalk(this@LoginActivity) { token, error ->
                    if (error != null) {
                        // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                        // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                        if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                            return@loginWithKakaoTalk
                        }
                        // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                        kakaoAccountLogin()
                    } else if (token != null) {
                        viewModel.addKakaoToken(token)
                    }
                }
            } else {
                kakaoAccountLogin()
            }
        }
    }

    private fun kakaoAccountLogin() {
        UserApiClient.instance.loginWithKakaoAccount(this) { token, error ->
            if (error != null) {
                Toast.makeText(
                    this,
                    " 로그인 실패",
                    Toast.LENGTH_SHORT,
                ).show()
            } else if (token != null) {
                viewModel.addKakaoToken(token)
                Toast.makeText(
                    this,
                    " 로그인 성공",
                    Toast.LENGTH_SHORT,
                ).show()
                Log.d("Kakao Token : ", token.accessToken)
                navigateToHome()
            }
        }
    }

    private fun getKakaoKeyHash(): String {
        return Utility.getKeyHash(this)
    }

    private fun navigateToHome() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }
}
