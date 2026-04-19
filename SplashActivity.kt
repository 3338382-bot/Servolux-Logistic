
package com.example.app

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo = findViewById<ImageView>(R.id.logo)

        logo.alpha = 0f

        logo.animate()
            .alpha(1f)
            .setDuration(700)
            .withEndAction {
                logo.animate()
                    .alpha(0f)
                    .setDuration(500)
                    .setStartDelay(300)
                    .withEndAction {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }
            }
    }
}
