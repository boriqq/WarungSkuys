package com.example.warungskuy.activities

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.warungskuy.databinding.ActivityProfileBinding
import com.example.warungskuy.utils.SessionManager

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        setupToolbar()
        loadUserData()

        binding.btnLogout.setOnClickListener {
            showLogoutConfirmation()
        }
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun loadUserData() {
        val user = sessionManager.getCurrentUser()
        if (user != null) {
            binding.tvFullName.text = user.fullName
            binding.tvUsername.text = user.username
            binding.tvPhone.text = if (user.phone.isNotEmpty()) user.phone else "-"
        }

        // Hitung total orders
        val totalOrders = sessionManager.getOrderHistory().size
        binding.tvTotalOrders.text = totalOrders.toString()
    }

    private fun showLogoutConfirmation() {
        AlertDialog.Builder(this)
            .setTitle("Logout")
            .setMessage("Apakah kamu yakin ingin keluar?")
            .setPositiveButton("Ya") { _, _ ->
                logout()
            }
            .setNegativeButton("Tidak", null)
            .show()
    }

    private fun logout() {
        sessionManager.logout()

        // Redirect ke Auth Choice
        val intent = Intent(this, AuthChoiceActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()
    }
}