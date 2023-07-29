package com.mashup.alcoholfree.presentation.ui.register

import android.webkit.JavascriptInterface
import com.mashup.alcoholfree.presentation.ui.measuring.SulSulWebViewBridge

class RegisterTierBridge(
    private val onSuccess: (alcoholType: String, glasses: Int) -> Unit
): SulSulWebViewBridge {
    override val bridgeName: String = BRIDGE_NAME

    /**
     * 온보딩에서 주량등록 완료했을 때
     */
    @JavascriptInterface
    fun onRegisterSuccess(alcoholType: String, glasses: Int) {
        onSuccess(alcoholType, glasses)
    }

    companion object {
        private const val BRIDGE_NAME = "sulsulBridge"
    }
}
