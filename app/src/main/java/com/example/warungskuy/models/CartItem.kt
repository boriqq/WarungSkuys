package com.example.warungskuy.models

data class CartItem(
    val food: Food,
    var quantity: Int = 1
) {
    fun getTotalPrice(): Int = food.price * quantity
}