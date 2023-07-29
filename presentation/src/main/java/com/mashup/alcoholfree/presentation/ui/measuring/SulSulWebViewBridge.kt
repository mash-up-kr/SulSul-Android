package com.mashup.alcoholfree.presentation.ui.measuring

import android.webkit.WebView

interface SulSulWebViewBridge {
    fun publishEvent(functionName: String, data: String): String

    fun onWebViewClicked(webView: WebView, data: String?)
}
