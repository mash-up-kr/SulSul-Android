package com.mashup.alcoholfree.presentation.ui.component

import android.annotation.SuppressLint
import android.view.HapticFeedbackConstants
import android.view.MotionEvent
import android.webkit.WebView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.web.WebView
import com.google.accompanist.web.WebViewState
import com.mashup.alcoholfree.presentation.constants.WebViewConstant
import com.mashup.alcoholfree.presentation.ui.measuring.MeasuringWebViewBridge

private lateinit var currentAlcohol: String

@SuppressLint("SetJavaScriptEnabled", "JavascriptInterface")
@Composable
fun SulSulWebView(
    modifier: Modifier = Modifier,
    state: WebViewState,
    currentAlcoholType: String,
) {
    currentAlcohol = currentAlcoholType

    WebView(
        modifier = modifier,
        state = state,
        onCreated = { webView ->
            val webViewBridge = MeasuringWebViewBridge(webView)
            with(webView) {
                setBackgroundColor(0) // 웹뷰 투명 배경
                settings.javaScriptEnabled = true
                addJavascriptInterface(webViewBridge, WebViewConstant.BRIDGE_NAME)
                onWebViewTouch(webView, webViewBridge)
            }
        },
    )
}

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun SulSulWebView(
    modifier: Modifier = Modifier,
    state: WebViewState,
) {
    WebView(
        modifier = modifier,
        state = state,
        onCreated = { webView ->
            with(webView) {
                settings.javaScriptEnabled = true
            }
        },
    )
}

@SuppressLint("ClickableViewAccessibility")
private fun onWebViewTouch(webView: WebView, webViewBridge: MeasuringWebViewBridge) {
    webView.setOnTouchListener { view, motionEvent ->
        if (
            view.id == webView.id &&
            motionEvent.action == MotionEvent.ACTION_DOWN
        ) {
            view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
            webViewBridge.addBallClickListener(currentAlcohol)
        }
        false
    }
}
