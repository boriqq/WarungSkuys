package com.example.warungskuy.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.warungskuy.R
import com.example.warungskuy.databinding.ItemHistoryBinding
import com.example.warungskuy.models.OrderHistory
import java.text.NumberFormat
import java.util.Locale

class HistoryAdapter(
    private val historyList: List<OrderHistory>,
    private val onItemClick: (OrderHistory) -> Unit
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {

    inner class HistoryViewHolder(private val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(orderHistory: OrderHistory) {
            binding.tvOrderId.text = "Order #${orderHistory.orderId.takeLast(8)}"
            binding.tvDate.text = orderHistory.date
            binding.tvItemCount.text = "${orderHistory.items.size} items"
            binding.tvTotalPrice.text = formatPrice(orderHistory.totalPrice)
            binding.tvStatus.text = orderHistory.status

            // Warna status
            if (orderHistory.status == "Selesai") {
                binding.tvStatus.setBackgroundColor(Color.parseColor("#76C147"))  // Green dari logo
            } else {
                binding.tvStatus.setBackgroundColor(Color.parseColor("#F5B041"))  // Yellow dari logo
            }

            binding.root.setOnClickListener {
                onItemClick(orderHistory)
            }
        }

        private fun formatPrice(price: Int): String {
            val format = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
            return format.format(price).replace(",00", "")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val binding = ItemHistoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return HistoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(historyList[position])
    }

    override fun getItemCount(): Int = historyList.size
}