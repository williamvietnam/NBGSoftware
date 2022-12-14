package com.nbgsoftware.base

import android.graphics.Bitmap
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.LayoutRes
import androidx.viewbinding.ViewBinding

/**
 * Author: William Giang Nguyen | 8/7/2022
 * */
abstract class BaseWebViewFragment<
        VB : ViewBinding,
        VM : BaseViewModel>(
    @LayoutRes id: Int
) : SaveViewBaseFragment<VB, VM>(id) {

    fun WebView.loadData(url: String) {
        webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                showHideLoading(true)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                showHideLoading(false)
            }
        }

        apply {
            settings.javaScriptEnabled = true
            settings.javaScriptCanOpenWindowsAutomatically = true
            settings.domStorageEnabled = true
            settings.useWideViewPort = true
            settings.loadWithOverviewMode = true
            settings.allowContentAccess = true
            settings.allowFileAccess = true
            settings.databaseEnabled = true
            settings.setSupportZoom(true)
            loadUrl(url)
        }
    }
}