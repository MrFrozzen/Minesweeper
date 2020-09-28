package ru.mrfrozzen.minesweeper

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.RequestConfiguration
import com.google.firebase.analytics.FirebaseAnalytics




class MainActivity : AppCompatActivity() {

    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        MobileAds.initialize(this) {}
        mAdView = findViewById(R.id.adView)

        MobileAds.setRequestConfiguration(
            RequestConfiguration.Builder()
                .setTestDeviceIds(listOf("ECB43FF4FEC70E712026992CA3A91CB4"))
                .build()
        )

        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        val toolbar = findViewById<Toolbar>(R.id.game_toolbar)
        setSupportActionBar(toolbar)
        NavigationUI.setupWithNavController(toolbar, findNavController(R.id.nav_host))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.game_menu, menu)
        return true
    }

    // Called when leaving the activity
    public override fun onPause() {
        mAdView.pause()
        super.onPause()
    }

    // Called when returning to the activity
    public override fun onResume() {
        super.onResume()
        mAdView.resume()
    }

    // Called before the activity is destroyed
    public override fun onDestroy() {
        mAdView.destroy()
        super.onDestroy()
    }

}
