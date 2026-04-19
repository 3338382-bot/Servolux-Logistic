package com.example.bluewebview
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import com.example.bluewebview.databinding.ActivitySettingsBinding
class SettingsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding
    private val prefs by lazy { getSharedPreferences(MainActivity.PREFS_NAME, MODE_PRIVATE) }
    override fun onCreate(savedInstanceState: Bundle?) { super.onCreate(savedInstanceState); binding = ActivitySettingsBinding.inflate(layoutInflater); setContentView(binding.root); binding.urlEditText.setText(prefs.getString(MainActivity.KEY_URL, MainActivity.DEFAULT_URL) ?: MainActivity.DEFAULT_URL); binding.saveButton.setOnClickListener { val url = binding.urlEditText.text?.toString()?.trim().orEmpty(); if (url.isNotEmpty()) { prefs.edit { putString(MainActivity.KEY_URL, url) }; startActivity(Intent(this, MainActivity::class.java).apply { addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP); putExtra(MainActivity.EXTRA_RELOAD_URL, true) }); finish() } else binding.urlInputLayout.error = "Введите URL" } }
}
