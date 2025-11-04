package com.example.warungskuy.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.warungskuy.databinding.ActivityLoginBinding
import com.example.warungskuy.utils.SessionManager

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (username.isEmpty()) {
                binding.tilUsername.error = "Username tidak boleh kosong"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.tilPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }

            // Clear error
            binding.tilUsername.error = null
            binding.tilPassword.error = null

            // Cari user di database (SharedPreferences)
            val user = sessionManager.findUser(username, password)

            if (user != null) {
                // Login berhasil
                sessionManager.setLogin(user)
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()

                // Ke Home
                startActivity(Intent(this, ProductsActivity::class.java))
                finishAffinity() // Clear semua activity sebelumnya
            } else {
                Toast.makeText(this, "Username atau password salah!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvSignUp.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }
    }
}