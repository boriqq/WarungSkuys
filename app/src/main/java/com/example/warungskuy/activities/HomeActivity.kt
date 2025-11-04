package com.example.warungskuy.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.warungskuy.R
import com.example.warungskuy.databinding.ActivityHomeNewBinding
import com.example.warungskuy.utils.SessionManager

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeNewBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeNewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        loadWelcomeMessage()
        setupBottomNavigation()

        binding.btnLihatMenu.setOnClickListener {
            startActivity(Intent(this, ProductsActivity::class.java))
        }
    }

    private fun loadWelcomeMessage() {
        val user = sessionManager.getCurrentUser()
        if (user != null) {
            binding.tvWelcomeUser.text = "Halo, ${user.fullName}!"
        }
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    // Sudah di home
                    true
                }
                R.id.nav_products -> {
                    startActivity(Intent(this, ProductsActivity::class.java))
                    true
                }
                R.id.nav_orders -> {
                    // Tampilkan pilihan: Cart atau History
                    val options = arrayOf("Keranjang", "Riwayat Pesanan")
                    android.app.AlertDialog.Builder(this)
                        .setTitle("Pesanan")
                        .setItems(options) { _, which ->
                            when (which) {
                                0 -> startActivity(Intent(this, CartActivity::class.java))
                                1 -> startActivity(Intent(this, HistoryActivity::class.java))
                            }
                        }
                        .show()
                    true
                }
                R.id.nav_profile -> {
                    startActivity(Intent(this, ProfileActivity::class.java))
                    true
                }
                else -> false
            }
        }

        // Set selected item
        binding.bottomNavigation.selectedItemId = R.id.nav_home
    }
}