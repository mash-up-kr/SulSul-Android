package com.mashup.alcoholfree.presentation.ui.tiercard

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import com.mashup.alcoholfree.presentation.ui.component.SulSulWebViewClient
import java.net.URISyntaxException

class KakaoShareWebViewClient(
    private val context: Context,
    onIsWebViewLoading: (Boolean) -> Unit,
    private val onStartKakao: (Intent) -> Unit,
) : SulSulWebViewClient(onIsWebViewLoading) {
    override fun shouldOverrideUrlLoading(
        view: WebView,
        request: WebResourceRequest?,
    ): Boolean {
        request?.let {
            if (request.url.scheme == "intent") {
                try {
                    val intent = Intent.parseUri(
                        request.url.toString(),
                        Intent.URI_INTENT_SCHEME,
                    )

                    if (intent.resolveActivity(context.packageManager) != null) {
                        onStartKakao(intent)
                        return true
                    }

                    val intentStore = Intent(Intent.ACTION_VIEW).apply {
                        addCategory(Intent.CATEGORY_DEFAULT)
                        data = Uri.parse(KAKAO_STORE_URL)
                    }
                    onStartKakao(intentStore)
                    return true
                } catch (e: URISyntaxException) {
                    Log.e("kakaoWebView", "Invalid intent request", e)
                }
            }
        }
        return false
    }

    companion object {
        private const val KAKAO_STORE_URL = "market://details?id=com.kakao.talk"
    }
}
