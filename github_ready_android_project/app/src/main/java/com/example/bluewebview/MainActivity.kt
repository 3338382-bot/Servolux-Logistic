package com.example.bluewebview
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.bluewebview.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val prefs by lazy { getSharedPreferences(PREFS_NAME, MODE_PRIVATE) }
    override fun onCreate(savedInstanceState: Bundle?) { installSplashScreen(); super.onCreate(savedInstanceState); binding = ActivityMainBinding.inflate(layoutInflater); setContentView(binding.root); setupWebView(); setupUi(); setupBackPress(); loadSavedUrl() }
    override fun onResume() { super.onResume(); if (intent.getBooleanExtra(EXTRA_RELOAD_URL, false)) { intent.removeExtra(EXTRA_RELOAD_URL); loadSavedUrl() } }
    private fun setupUi() { binding.swipeRefreshLayout.setColorSchemeResources(R.color.blue_500, R.color.blue_700, R.color.blue_200); binding.swipeRefreshLayout.setOnRefreshListener { binding.webView.reload() }; binding.fabSettings.setOnClickListener { startActivity(Intent(this, SettingsActivity::class.java)) } }
    private fun setupWebView() { binding.webView.settings.javaScriptEnabled = true; binding.webView.settings.domStorageEnabled = true; binding.webView.webViewClient = object : WebViewClient() { override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) { binding.progressBar.visibility = View.VISIBLE; binding.progressBar.progress = 0; binding.swipeRefreshLayout.isRefreshing = true } override fun onPageFinished(view: WebView?, url: String?) { binding.progressBar.visibility = View.GONE; binding.swipeRefreshLayout.isRefreshing = false } }; binding.webView.webChromeClient = object : WebChromeClient() { override fun onProgressChanged(view: WebView?, newProgress: Int) { binding.progressBar.visibility = View.VISIBLE; binding.progressBar.setProgressCompat(newProgress, true); if (newProgress >= 100) { binding.progressBar.visibility = View.GONE; binding.swipeRefreshLayout.isRefreshing = false } } } }
    private fun loadSavedUrl() { binding.webView.loadUrl(prefs.getString(KEY_URL, DEFAULT_URL) ?: DEFAULT_URL) }
    private fun setupBackPress() { onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) { override fun handleOnBackPressed() { if (binding.webView.canGoBack()) binding.webView.goBack() else finish() } }) }
    override fun onDestroy() { binding.webView.destroy(); super.onDestroy() }
    companion object { const val PREFS_NAME = "webview_prefs"; const val KEY_URL = "saved_url"; const val DEFAULT_URL = "https://example.com"; const val EXTRA_RELOAD_URL = "extra_reload_url" }
}
