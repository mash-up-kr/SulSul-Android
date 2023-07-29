package com.mashup.alcoholfree.presentation.ui.component

import android.annotation.SuppressLint
import android.view.HapticFeedbackConstants
import android.view.MotionEvent
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.mashup.alcoholfree.presentation.ui.measuring.SulSulWebViewBridge
import com.mashup.alcoholfree.presentation.ui.measuring.SulSulWebViewSendBridge
import com.mashup.alcoholfree.presentation.ui.measuring.model.SulSulWebViewState

private var currentType: String? = null

@SuppressLint("SetJavaScriptEnabled", "JavascriptInterface")
@Composable
fun SulSulWebView(
    modifier: Modifier = Modifier,
    url: String,
    isTransparent: Boolean,
    state: SulSulWebViewState?,
    bridge: SulSulWebViewBridge?,
) {
    currentType = state?.clickMessage

    AndroidView(
        modifier = modifier,
        factory = {
        WebView(it).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            webViewClient = WebViewClient()
            webChromeClient = WebChromeClient()

            if (isTransparent) {
                setBackgroundColor(0) // 웹뷰 투명 배경
            }
            settings.javaScriptEnabled = true
            bridge?.let {
                addJavascriptInterface(bridge, bridge.bridgeName)
                if (bridge is SulSulWebViewSendBridge) {
                    onWebViewTouch(this, bridge, state)
                }
            }

            loadUrl(url)
        }
    })
}

@SuppressLint("ClickableViewAccessibility")
private fun onWebViewTouch(
    webView: WebView,
    webViewBridge: SulSulWebViewSendBridge,
    state: SulSulWebViewState?,
) {
    webView.setOnTouchListener { view, motionEvent ->
        if (
            view.id == webView.id &&
            motionEvent.action == MotionEvent.ACTION_DOWN
        ) {
            view.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY)
            webViewBridge.onWebViewClicked(webView, currentType)
        }
        false
    }
}
