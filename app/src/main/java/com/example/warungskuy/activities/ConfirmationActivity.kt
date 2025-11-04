package com.example.warungskuy.activities

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.warungskuy.adapters.OrderSummaryAdapter
import com.example.warungskuy.databinding.ActivityConfirmationBinding
import com.example.warungskuy.models.OrderHistory
import com.example.warungskuy.utils.SessionManager
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class ConfirmationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityConfirmationBinding
    private lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfirmationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        setupToolbar()
        loadData()

        binding.btnConfirmOrder.setOnClickListener {
            confirmOrder()
        }
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun loadData() {
        // Get data dari intent
        val recipientName = intent.getStringExtra("recipientName") ?: ""
        val phone = intent.getStringExtra("phone") ?: ""
        val address = intent.getStringExtra("address") ?: ""

        // Set alamat
        binding.tvRecipientName.text = recipientName
        binding.tvPhone.text = phone
        binding.tvAddress.text = address

        // Get cart
        val cart = sessionManager.getCart()

        // Setup RecyclerView
        val adapter = OrderSummaryAdapter(cart)
        binding.rvOrderSummary.apply {
            layoutManager = LinearLayoutManager(this@ConfirmationActivity)
            this.adapter = adapter
        }

        // Hitung total
        val total = cart.sumOf { it.getTotalPrice() }
        binding.tvTotalPrice.text = formatPrice(total)
    }

    private fun confirmOrder() {
        val cart = sessionManager.getCart()

        if (cart.isEmpty()) {
            finish()
            return
        }

        // Generate order ID
        val orderId = "ORD${System.currentTimeMillis()}"

        // Get current date
        val dateFormat = SimpleDateFormat("dd MMMM yyyy, HH:mm", Locale("id", "ID"))
        val currentDate = dateFormat.format(Date())

        // Get data alamat
        val recipientName = intent.getStringExtra("recipientName") ?: ""
        val phone = intent.getStringExtra("phone") ?: ""
        val address = intent.getStringExtra("address") ?: ""

        // Hitung total
        val total = cart.sumOf { it.getTotalPrice() }

        // Buat order history
        val orderHistory = OrderHistory(
            orderId = orderId,
            date = currentDate,
            items = cart.toList(),
            totalPrice = total,
            address = address,
            recipientName = recipientName,
            phone = phone,
            status = "Diproses"
        )

        // Simpan ke history
        sessionManager.saveOrderHistory(orderHistory)

        // Clear cart
        sessionManager.clearCart()

        // Show success dialog
        showSuccessDialog()
    }

    private fun showSuccessDialog() {
        AlertDialog.Builder(this)
            .setTitle("Pesanan Berhasil!")
            .setMessage("Pesanan kamu sedang diproses. Terima kasih sudah memesan di WarungSkuy!")
            .setPositiveButton("OK") { _, _ ->
                // Kembali ke Home dan clear semua activity
                val intent = Intent(this, ProductsActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
            .setCancelable(false)
            .show()
    }

    private fun formatPrice(price: Int): String {
        val format = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
        return format.format(price).replace(",00", "")
    }
}