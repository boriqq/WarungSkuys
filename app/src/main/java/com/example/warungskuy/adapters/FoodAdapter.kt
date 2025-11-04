package com.example.warungskuy.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.warungskuy.databinding.ItemFoodBinding
import com.example.warungskuy.models.Food
import java.text.NumberFormat
import java.util.Locale

class FoodAdapter(
    private val foodList: List<Food>,
    private val onAddClick: (Food) -> Unit
) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    inner class FoodViewHolder(private val binding: ItemFoodBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(food: Food) {
            binding.ivFood.setImageResource(food.imageRes)
            binding.tvFoodName.text = food.name
            binding.tvFoodPrice.text = formatPrice(food.price)

            binding.btnAdd.setOnClickListener {
                onAddClick(food)
            }
        }

        private fun formatPrice(price: Int): String {
            val format = NumberFormat.getCurrencyInstance(Locale("id", "ID"))
            return format.format(price).replace(",00", "")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val binding = ItemFoodBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FoodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodList[position])
    }

    override fun getItemCount(): Int = foodList.size
}