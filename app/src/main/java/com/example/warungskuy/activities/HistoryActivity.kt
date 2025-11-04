package com.example.warungskuy.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.warungskuy.adapters.HistoryAdapter
import com.example.warungskuy.databinding.ActivityHistoryBinding
import com.example.warungskuy.utils.SessionManager

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding
    private lateinit var sessionManager: SessionManager
    private lateinit var historyAdapter: HistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sessionManager = SessionManager(this)

        setupToolbar()
        setupRecyclerView()
        updateUI()
    }

    private fun setupToolbar() {
        binding.toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupRecyclerView() {
        val history = sessionManager.getOrderHistory()

        historyAdapter = HistoryAdapter(history) { orderHistory ->
            // Klik item -> ke detail
            val intent = Intent(this, DetailHistoryActivity::class.java)
            intent.putExtra("orderId", orderHistory.orderId)
            startActivity(intent)
        }

        binding.rvHistory.apply {
            layoutManager = LinearLayoutManager(this@HistoryActivity)
            adapter = historyAdapter
        }
    }

    private fun updateUI() {
        val history = sessionManager.getOrderHistory()

        if (history.isEmpty()) {
            binding.rvHistory.visibility = View.GONE
            binding.llEmpty.visibility = View.VISIBLE
        } else {
            binding.rvHistory.visibility = View.VISIBLE
            binding.llEmpty.visibility = View.GONE
        }
    }
}