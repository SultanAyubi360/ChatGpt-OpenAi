package com.sultanayubi.chatgpt

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.WindowManager
import android.webkit.CookieManager
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sultanayubi.chatgpt.databinding.ActivityWebBinding


class WebActivity : AppCompatActivity() {

    private val userAgent =
        "Mozilla/5.0 (Linux; Android " + Build.VERSION.RELEASE + ") AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.5359.79 Mobile Safari/537.36"

    private var _binding: ActivityWebBinding? = null
    private val binding get() = _binding!!
    lateinit var bottomNav: BottomNavigationView
    lateinit var adRequest: AdRequest
    private var mInterstitialAd: InterstitialAd? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityWebBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = Color.parseColor("#343541")


        binding.webView.webViewClient = object : WebViewClient() {
            override fun onLoadResource(view: WebView, url: String) {
                if (view is CustomWebView && url == "https://chat.openai.com/backend-api/models") {
                    view.loggedIn = true
                }
                return super.onLoadResource(view, url)
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                val url = request?.url.toString()
                view?.loadUrl(url)
                return super.shouldOverrideUrlLoading(view, request)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

                //Save the last visited URL
                saveUrl(url)
            }
        }


        binding.webView.requestFocus(View.FOCUS_DOWN)
        binding.webView.requestFocusFromTouch()
        binding.webView.settings.userAgentString = userAgent
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.domStorageEnabled = true
        binding.webView.settings.saveFormData = false
        CookieManager.getInstance().acceptCookie()
        binding. webView.settings.cacheMode = WebSettings.LOAD_DEFAULT
        binding.webView.loadUrl(getUrl()!!)


        binding.webView.setOnTouchListener(OnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN, MotionEvent.ACTION_UP -> if (!v.hasFocus()) {
                    v.requestFocus()
                }
            }
            false
        })

        bottomNav = findViewById(R.id.bottom_navigation) as BottomNavigationView

        bottomNav.setSelectedItemId(R.id.chat);
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.dashboard -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }

                R.id.help -> {
                    startActivity(Intent(applicationContext, HelpActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }

                R.id.chat -> {
                    true
                }

                R.id.about -> {
                    startActivity(Intent(applicationContext, AboutActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }

                R.id.faq -> {
                    startActivity(Intent(applicationContext, FaqActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }

                else -> {
                    false
                }
            }
        }

    }

    fun saveUrl(url: String?) {
        val sp = getSharedPreferences("SP_WEBVIEW_PREFS", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sp.edit()
        editor.putString("SAVED_URL", url)
        editor.commit()
    }

    fun getUrl(): String? {
        val sp = getSharedPreferences("SP_WEBVIEW_PREFS", MODE_PRIVATE)
        return sp.getString("SAVED_URL", "https://chat.openai.com/auth/login")
    }


    override fun onKeyDown(keyCode: Int, event: KeyEvent): Boolean {
        if (event.getAction() === KeyEvent.ACTION_DOWN) {
            when (keyCode) {
                KeyEvent.KEYCODE_BACK -> {
                    if (binding.webView.canGoBack()) {
                        binding.webView.goBack()
                    } else {
                        add()
                        finish()
                    }
                    return true
                }
            }
        }
        return super.onKeyDown(keyCode, event)
    }

    fun add() {
        adRequest = AdRequest.Builder().build()
        InterstitialAd.load(
            applicationContext, "ca-app-pub-3940256099942544/1033173712", adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    mInterstitialAd = interstitialAd
                    if (mInterstitialAd != null) {
                        mInterstitialAd!!.show(this@WebActivity)
                    } else {
                        Log.d("TAG", "The interstitial ad wasn't ready yet.")
                    }
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    mInterstitialAd = null
                }
            })

    }

}