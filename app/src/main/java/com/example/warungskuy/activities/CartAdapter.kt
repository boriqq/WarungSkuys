package com.example.warungskuy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.warungskuy.databinding.ItemCartBinding
import com.example.warungskuy.models.CartItem
import java.text.NumberFormat
import java.util.Locale

class CartAdapter(
    private var cart: MutableList<CartItem>,
    private val onQuantityChanged: () -> Unit,
    private val onItemDeleted: () -> Unit
) : RecyclerView.Adapter<CartAdapter.CartViewHolder>() {

    inner class CartViewHolder(private val binding: ItemCartBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(cartItem: CartItem, position: Int) {
            binding.ivFood.setImageResource(cartItem.food.imageRes)
            binding.tvFoodName.text = cartItem.food.name
            binding.tvFoodPrice.text = formatPrice(cartItem.food.price)
            binding.tvQuantity.text = cartItem.quantity.toString()
            binding.tvItemTotal.text = formatPrice(cartItem.getTotalPrice())

            // Tombol plus
            binding.btnPlus.setOnClickListener {
                cartItem.quantity++
                notifyItemChanged(position)
                onQuantityChanged()
            }

            // Tombol minus
            binding.btnMinus.setOnClickListener {
                if (cartItem.quantity > 1) {
                    cartItem.quantity--
                    notifyItemChanged(position)
                    onQuantityChanged()
                }
            }

            // Tombol delete
            binding.btnDelete.setOnClickListener {
                cart.removeAt(position)
                notifyItemRemoved(position)
                notifyItemRangeChanged(position, cart.size)
                onItemDeleted()
            }
        }

        private fun formatPrice(price: Int): String {
            val format = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
            return format.format(price).replace(",00", "")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val binding = ItemCartBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CartViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.bind(cart[position], position)
    }

    override fun getItemCount(): Int = cart.size

    fun getCart(): MutableList<CartItem> = cart

    fun updateCart(newCart: MutableList<CartItem>) {
        cart = newCart
        notifyDataSetChanged()
    }
}