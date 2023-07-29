package com.mashup.alcoholfree.presentation.ui.register

import android.webkit.JavascriptInterface

class RegisterTierBridge(
    private val onSuccess: (alcoholType: String, glasses: Int) -> Unit
) {

    /**
     * 온보딩에서 주량등록 완료했을 때
     */
    @JavascriptInterface
    fun onRegisterSuccess(alcoholType: String, glasses: Int) {
        onSuccess(alcoholType, glasses)
    }
}
