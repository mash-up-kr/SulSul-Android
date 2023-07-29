package com.mashup.alcoholfree.presentation.ui.register

import android.content.Context
import android.webkit.JavascriptInterface
import android.widget.Toast

class RegisterTierBridge(
    private val context: Context,
) {

    /**
     * 온보딩에서 주량등록 성공했을 때
     */
    @JavascriptInterface
    fun onRegisterSuccess(alcoholType: String, glasses: Int) {
        Toast.makeText(context, "$alcoholType ${glasses}잔", Toast.LENGTH_SHORT).show()
    }
}
