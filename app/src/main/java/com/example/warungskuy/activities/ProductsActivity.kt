package com.example.warungskuy.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.warungskuy.R
import com.example.warungskuy.adapters.FoodAdapter
import com.example.warungskuy.data.FoodData
import com.example.warungskuy.databinding.ActivityHomeBinding
import com.example.warungskuy.models.CartItem
import com.example.warungskuy.models.Food
import com.example.warungskuy.utils.SessionManager

class ProductsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var sessionManager: SessionManager
    private lateinit var foodAdapter: FoodAdapter
    private val cart = mutableListOf<CartItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        // Ganti title toolbar
        binding.toolbar.title = "Produk Makanan"

        // Load cart dari session
        cart.addAll(sessionManager.getCart())

        setupRecyclerView()
        setupBottomNavigation()
    }

    private fun setupRecyclerView() {
        val foodList = FoodData.getFoodList()

        foodAdapter = FoodAdapter(foodList) { food ->
            addToCart(food)
        }

        binding.rvFood.apply {
            layoutManager = LinearLayoutManager(this@ProductsActivity)
            adapter = foodAdapter
        }
    }

    private fun addToCart(food: Food) {
        // Cek apakah item sudah ada di cart
        val existingItem = cart.find { it.food.id == food.id }

        if (existingItem != null) {
            // Tambah quantity
            existingItem.quantity++
        } else {
            // Tambah item baru
            cart.add(CartItem(food, 1))
        }

        // Simpan cart
        sessionManager.saveCart(cart)

        Toast.makeText(this, "${food.name} ditambahkan ke keranjang", Toast.LENGTH_SHORT).show()
    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                    true
                }
                R.id.nav_products -> {
                    // Sudah di products
                    true
                }
                R.id.nav_orders -> {
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
        binding.bottomNavigation.selectedItemId = R.id.nav_products
    }

    override fun onResume() {
        super.onResume()
        // Reload cart setiap kembali ke products
        cart.clear()
        cart.addAll(sessionManager.getCart())
    }
}