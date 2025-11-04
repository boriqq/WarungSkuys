package com.example.warungskuy.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.warungskuy.databinding.ActivityAddressBinding
import com.example.warungskuy.utils.SessionManager

class AddressActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddressBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        setupToolbar()
        loadUserData()

        binding.btnNext.setOnClickListener {
            validateAndProceed()
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
            binding.etRecipientName.setText(user.fullName)
            binding.etPhone.setText(user.phone)
        }
    }

    private fun validateAndProceed() {
        val recipientName = binding.etRecipientName.text.toString().trim()
        val phone = binding.etPhone.text.toString().trim()
        val address = binding.etAddress.text.toString().trim()

        // Validasi
        if (recipientName.isEmpty()) {
            binding.tilRecipientName.error = "Nama penerima tidak boleh kosong"
            return
        }

        if (phone.isEmpty()) {
            binding.tilPhone.error = "No. HP tidak boleh kosong"
            return
        }

        if (address.isEmpty()) {
            binding.tilAddress.error = "Alamat tidak boleh kosong"
            return
        }

        // Clear error
        binding.tilRecipientName.error = null
        binding.tilPhone.error = null
        binding.tilAddress.error = null

        // Kirim data ke ConfirmationActivity
        val intent = Intent(this, ConfirmationActivity::class.java).apply {
            putExtra("recipientName", recipientName)
            putExtra("phone", phone)
            putExtra("address", address)
        }
        startActivity(intent)
    }
}