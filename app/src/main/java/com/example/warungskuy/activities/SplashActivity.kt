package com.example.warungskuy.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.warungskuy.databinding.ActivitySplashBinding
import com.example.warungskuy.utils.SessionManager

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        // Delay 2 detik
        Handler(Looper.getMainLooper()).postDelayed({
            // Cek apakah user sudah login
            if (sessionManager.isLoggedIn()) {
                // Langsung ke Home
                startActivity(Intent(this, ProductsActivity::class.java))
            } else {
                // Ke Auth Choice
                startActivity(Intent(this, AuthChoiceActivity::class.java))
            }
            finish()
        }, 2000) // 2000ms = 2 detik
    }
}