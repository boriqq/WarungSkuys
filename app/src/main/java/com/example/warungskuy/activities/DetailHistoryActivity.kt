package com.example.warungskuy.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.warungskuy.adapters.OrderSummaryAdapter
import com.example.warungskuy.databinding.ActivityDetailHistoryBinding
import com.example.warungskuy.models.CartItem
import com.example.warungskuy.models.OrderHistory
import com.example.warungskuy.utils.SessionManager
import java.text.NumberFormat
import java.util.Locale

class DetailHistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailHistoryBinding
    private lateinit var sessionManager: SessionManager
    private var currentOrder: OrderHistory? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        setupToolbar()
        loadOrderDetail()

        binding.btnReorder.setOnClickListener {
            reorder()
        }
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun loadOrderDetail() {
        val orderId = intent.getStringExtra("orderId") ?: return

        // Cari order dari history
        val history = sessionManager.getOrderHistory()
        val order = history.find { it.orderId == orderId }

        if (order == null) {
            Toast.makeText(this, "Order tidak ditemukan", Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        currentOrder = order

        // Set data
        binding.tvOrderId.text = "Order #${order.orderId.takeLast(8)}"
        binding.tvDate.text = order.date
        binding.tvStatus.text = order.status

        // Warna status
        if (order.status == "Selesai") {
            binding.tvStatus.setBackgroundColor(Color.parseColor("#4CAF50"))
        } else {
            binding.tvStatus.setBackgroundColor(Color.parseColor("#FF9800"))
        }

        // Set alamat
        binding.tvRecipientName.text = order.recipientName
        binding.tvPhone.text = order.phone
        binding.tvAddress.text = order.address

        // Set items
        val adapter = OrderSummaryAdapter(order.items)
        binding.rvItems.apply {
            layoutManager = LinearLayoutManager(this@DetailHistoryActivity)
            this.adapter = adapter
        }

        // Set total
        binding.tvTotalPrice.text = formatPrice(order.totalPrice)
    }

    private fun reorder() {
        val order = currentOrder ?: return

        // Ambil cart sekarang
        val currentCart = sessionManager.getCart()

        // Tambahkan items dari order ke cart
        order.items.forEach { orderItem ->
            val existingItem = currentCart.find { it.food.id == orderItem.food.id }
            if (existingItem != null) {
                existingItem.quantity += orderItem.quantity
            } else {
                currentCart.add(CartItem(orderItem.food, orderItem.quantity))
            }
        }

        // Simpan cart
        sessionManager.saveCart(currentCart)

        Toast.makeText(this, "Item ditambahkan ke keranjang!", Toast.LENGTH_SHORT).show()

        // Ke Cart
        val intent = Intent(this, CartActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
        startActivity(intent)
        finish()
    }

    private fun formatPrice(price: Int): String {
        val format = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
        return format.format(price).replace(",00", "")
    }
}