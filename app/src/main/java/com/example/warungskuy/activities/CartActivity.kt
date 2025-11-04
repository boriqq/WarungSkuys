package com.example.warungskuy.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.warungskuy.adapters.CartAdapter
import com.example.warungskuy.databinding.ActivityCartBinding
import com.example.warungskuy.utils.SessionManager
import java.text.NumberFormat
import java.util.Locale

class CartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCartBinding
    private lateinit var sessionManager: SessionManager
    private lateinit var cartAdapter: CartAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        setupToolbar()
        setupRecyclerView()
        updateUI()

        binding.btnCheckout.setOnClickListener {
            if (sessionManager.getCart().isNotEmpty()) {
                startActivity(Intent(this, AddressActivity::class.java))
            }
        }
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupRecyclerView() {
        cartAdapter = CartAdapter(
            cart = sessionManager.getCart(),
            onQuantityChanged = { updateUI() },
            onItemDeleted = {
                sessionManager.saveCart(cartAdapter.getCart())
                updateUI()
            }
        )

        binding.rvCart.apply {
            layoutManager = LinearLayoutManager(this@CartActivity)
            adapter = cartAdapter
        }
    }

    private fun updateUI() {
        val cart = cartAdapter.getCart()

        if (cart.isEmpty()) {
            binding.rvCart.visibility = View.GONE
            binding.cardTotal.visibility = View.GONE
            binding.llEmpty.visibility = View.VISIBLE
        } else {
            binding.rvCart.visibility = View.VISIBLE
            binding.cardTotal.visibility = View.VISIBLE
            binding.llEmpty.visibility = View.GONE

            // Hitung total
            val total = cart.sumOf { it.getTotalPrice() }
            binding.tvTotalPrice.text = formatPrice(total)
        }

        // Simpan perubahan cart
        sessionManager.saveCart(cart)
    }

    private fun formatPrice(price: Int): String {
        val format = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
        return format.format(price).replace(",00", "")
    }

    override fun onResume() {
        super.onResume()
        cartAdapter.updateCart(sessionManager.getCart())
        updateUI()
    }
}