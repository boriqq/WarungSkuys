package com.example.warungskuy.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.warungskuy.databinding.ActivityRegisterBinding
import com.example.warungskuy.models.User
import com.example.warungskuy.utils.SessionManager

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        binding.btnRegister.setOnClickListener {
            val fullName = binding.etFullName.text.toString().trim()
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            // Validasi
            if (fullName.isEmpty()) {
                binding.tilFullName.error = "Nama lengkap tidak boleh kosong"
                return@setOnClickListener
            }

            if (username.isEmpty()) {
                binding.tilUsername.error = "Username tidak boleh kosong"
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.tilPassword.error = "Password tidak boleh kosong"
                return@setOnClickListener
            }

            if (password.length < 6) {
                binding.tilPassword.error = "Password minimal 6 karakter"
                return@setOnClickListener
            }

            // Clear error
            binding.tilFullName.error = null
            binding.tilUsername.error = null
            binding.tilPassword.error = null

            // Cek apakah username sudah ada
            val existingUsers = sessionManager.getAllUsers()
            if (existingUsers.any { it.username == username }) {
                Toast.makeText(this, "Username sudah digunakan!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Buat user baru
            val newUser = User(
                username = username,
                password = password,
                fullName = fullName
            )

            // Simpan user
            sessionManager.saveUser(newUser)

            // Auto login
            sessionManager.setLogin(newUser)

            Toast.makeText(this, "Registrasi berhasil!", Toast.LENGTH_SHORT).show()

            // Ke Home
            startActivity(Intent(this, ProductsActivity::class.java))
            finishAffinity()
        }

        binding.tvLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}