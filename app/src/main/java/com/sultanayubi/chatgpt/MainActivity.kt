package com.sultanayubi.chatgpt

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sultanayubi.chatgpt.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding?= null
    private val binding get() = _binding!!
    lateinit var bottomNav : BottomNavigationView
    lateinit var  mAdView: AdView
    lateinit var  adRequest:AdRequest
    private var mInterstitialAd: InterstitialAd? = null

    private var infoAlertDialog: Dialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this) {}

        adRequest = AdRequest.Builder().build()
        mAdView = findViewById(R.id.Mainban)
        mAdView.loadAd(adRequest)

        val rateDialog = RateDialog(this)

        bottomNav = findViewById(R.id.bottom_navigation) as BottomNavigationView

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.startedBtn.setOnClickListener(){
            InterstitialAd.load(
                applicationContext, "ca-app-pub-3940256099942544/1033173712", adRequest,
                object : InterstitialAdLoadCallback() {
                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
                        mInterstitialAd = interstitialAd
                        if (mInterstitialAd != null) {
                            mInterstitialAd!!.show(this@MainActivity)
                        } else {
                            Log.d("TAG", "The interstitial ad wasn't ready yet.")
                        }
                    }

                    override fun onAdFailedToLoad(loadAdError: LoadAdError) {
                        mInterstitialAd = null
                    }
                })
            val intent = Intent(this, WebActivity::class.java)
            startActivity(intent)

        }

        binding.rateBtn.setOnClickListener(){
            rateDialog.show()
        }

        bottomNav.setSelectedItemId(R.id.dashboard);
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.dashboard -> {
                    true
                }
                R.id.help -> {
                    startActivity(Intent(applicationContext, HelpActivity::class.java))
                    overridePendingTransition(0, 0)
                    true
                }
                R.id.chat -> {
                    startActivity(Intent(applicationContext, WebActivity::class.java))
                    overridePendingTransition(0, 0)
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

    private fun infoDialog() {
        infoAlertDialog = Dialog(this)
        infoAlertDialog!!.setContentView(R.layout.info_dialog)
        infoAlertDialog!!.setCancelable(false)
        infoAlertDialog!!.setCanceledOnTouchOutside(false)
        val okayButton: Button = infoAlertDialog!!.findViewById<Button>(R.id.info_dialog_btn)
        val infoTextview: TextView =
            infoAlertDialog!!.findViewById<TextView>(R.id.info_dialog_details)
        infoTextview.movementMethod = LinkMovementMethod.getInstance()
        okayButton.setOnClickListener { v: View? ->
            infoAlertDialog!!.dismiss()
        }
        infoAlertDialog!!.getWindow()?.setLayout(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        infoAlertDialog!!.getWindow()?.setBackgroundDrawableResource(android.R.color.transparent)
        infoAlertDialog!!.show()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }

}
