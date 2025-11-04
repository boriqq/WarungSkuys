package com.example.warungskuy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.warungskuy.databinding.ItemOrderSummaryBinding
import com.example.warungskuy.models.CartItem
import java.text.NumberFormat
import java.util.Locale

class OrderSummaryAdapter(
    private val items: List<CartItem>
) : RecyclerView.Adapter<OrderSummaryAdapter.OrderSummaryViewHolder>() {

    inner class OrderSummaryViewHolder(private val binding: ItemOrderSummaryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cartItem: CartItem) {
            binding.tvItemName.text = cartItem.food.name
            binding.tvItemQuantity.text = "x${cartItem.quantity}"
            binding.tvItemPrice.text = formatPrice(cartItem.getTotalPrice())
        }

        private fun formatPrice(price: Int): String {
            val format = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
            return format.format(price).replace(",00", "")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderSummaryViewHolder {
        val binding = ItemOrderSummaryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return OrderSummaryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OrderSummaryViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}