package com.mashup.alcoholfree.presentation.ui.measuring

import android.webkit.JavascriptInterface
import android.webkit.WebView
import com.mashup.alcoholfree.presentation.constants.WebViewConstant

class MeasuringWebViewBridge(
    private val webView: WebView,
) {

    @JavascriptInterface
    fun publishEvent(
        functionName: String,
        alcoholType: String,
    ): String {
        val buffer = StringBuffer()
            .append("window.dispatchEvent(\n")
            .append("   new CustomEvent(\"").append(functionName).append("\", {\n")
            .append("           detail: {\n")
            .append("               data: ").append(alcoholType).append("\n")
            .append("           }\n")
            .append("       }\n")
            .append("   )\n")
            .append(");")
        return buffer.toString()
    }

    @JavascriptInterface
    fun addBallClickListener(alcoholType: String) {
        webView.evaluateJavascript(
            publishEvent(WebViewConstant.WEB_FUNCTION_NAME, alcoholType),
        ) {}
    }
}
