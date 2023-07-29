package com.mashup.alcoholfree.presentation.ui.measuring

import android.webkit.WebView

interface SulSulWebViewBridge {
    val bridgeName: String
}

interface SulSulWebViewSendBridge: SulSulWebViewBridge {
    fun publishEvent(functionName: String, data: String): String

    fun onWebViewClicked(webView: WebView, data: String?)
}
