package com.example.assignmentcits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.assignmentcits.databinding.ActivityWebViewBinding

class WebViewActivity : AppCompatActivity() {
    lateinit var bindingWebViewBinding: ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingWebViewBinding = ActivityWebViewBinding.inflate(layoutInflater)
        setContentView(bindingWebViewBinding.root)
        val url = intent.getStringExtra("URL")
        Log.d("URLS", "onCreateURLS: $url")
        if(url!=null){
            bindingWebViewBinding.webView.settings.javaScriptEnabled = true
            bindingWebViewBinding.webView.settings.userAgentString = "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_1 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Version/4.0 Mobile/14E304 Safari/602.1"
            bindingWebViewBinding.webView.webViewClient = object : WebViewClient(){
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    bindingWebViewBinding.progressBar.visibility = View.GONE
                    bindingWebViewBinding.webView.visibility = View.VISIBLE
                }
            }
            bindingWebViewBinding.webView.loadUrl(url)
        }
    }
}