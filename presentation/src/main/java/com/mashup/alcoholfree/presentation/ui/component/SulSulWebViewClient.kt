package com.mashup.alcoholfree.presentation.ui.component

import android.webkit.WebView
import android.webkit.WebViewClient

open class SulSulWebViewClient(
    private val onIsWebViewLoading: (Boolean) -> Unit,
) : WebViewClient() {
    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        onIsWebViewLoading(false)
    }
}
