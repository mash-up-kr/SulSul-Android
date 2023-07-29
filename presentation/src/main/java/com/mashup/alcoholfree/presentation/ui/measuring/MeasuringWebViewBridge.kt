package com.mashup.alcoholfree.presentation.ui.measuring

import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Toast

object MeasuringWebViewBridge : SulSulWebViewSendBridge {
    private const val WEB_FUNCTION_NAME = "addBall"
    private const val BRIDGE_NAME = "sulsulBridge"

    override val bridgeName: String = BRIDGE_NAME

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
        data?.let {
            webView.evaluateJavascript(
                publishEvent(WEB_FUNCTION_NAME, "\"$data\""),
            ) {}
        }
    }
}
