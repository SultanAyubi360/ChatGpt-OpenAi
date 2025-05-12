package com.sultanayubi.chatgpt

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sultanayubi.chatgpt.databinding.ActivityHelpBinding

class HelpActivity : AppCompatActivity() {

    private var _binding: ActivityHelpBinding?= null
    private val binding get() = _binding!!
    lateinit var bottomNav : BottomNavigationView
    lateinit var  mAdView: AdView
    lateinit var  adRequest: AdRequest
    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityHelpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.Helpbanner)
        adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        InterstitialAd.load(
            applicationContext, "ca-app-pub-3940256099942544/1033173712", adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    // The mInterstitialAd reference will be null until
                    // an ad is loaded.
                    mInterstitialAd = interstitialAd
                    if (mInterstitialAd != null) {
                        mInterstitialAd!!.show(this@HelpActivity)
                    } else {
                        Log.d("TAG", "The interstitial ad wasn't ready yet.")
                    }
                }

                override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                    // Handle the error
                    mInterstitialAd = null
                }
            })

        bottomNav = findViewById(R.id.bottom_navigation) as BottomNavigationView

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        bottomNav.setSelectedItemId(com.sultanayubi.chatgpt.R.id.help);
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                com.sultanayubi.chatgpt.R.id.dashboard -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                com.sultanayubi.chatgpt.R.id.help -> {
                    true
                }
                com.sultanayubi.chatgpt.R.id.chat -> {
                    startActivity(Intent(applicationContext, WebActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                com.sultanayubi.chatgpt.R.id.about -> {
                    startActivity(Intent(applicationContext, AboutActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                com.sultanayubi.chatgpt.R.id.faq -> {
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

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}