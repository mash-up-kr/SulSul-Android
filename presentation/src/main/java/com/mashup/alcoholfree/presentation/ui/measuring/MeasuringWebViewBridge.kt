package com.mashup.alcoholfree.presentation.ui.measuring

import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Toast

object MeasuringWebViewBridge : SulSulWebViewBridge {
    private const val WEB_FUNCTION_NAME = "addBall"

    @JavascriptInterface
    override fun publishEvent(
        functionName: String,
        data: String,
    ): String {
        val buffer = StringBuffer()
            .append("window.dispatchEvent(\n")
            .append("   new CustomEvent(\"").append(functionName).append("\", {\n")
            .append("           detail: {\n")
            .append("               data: ").append(data).append("\n")
            .append("           }\n")
            .append("       }\n")
            .append("   )\n")
            .append(");")
        return buffer.toString()
    }

    @JavascriptInterface
    override fun onWebViewClicked(webView: WebView, data: String?) {
        webView.evaluateJavascript(
            publishEvent(WEB_FUNCTION_NAME, "\"$data\""),
        ) {
            Toast.makeText(webView.context, data, Toast.LENGTH_SHORT).show()
        }
    }
}
