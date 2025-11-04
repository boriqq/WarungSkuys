package com.example.warungskuy.models

data class OrderHistory(
    val orderId: String,
    val date: String,
    val items: List<CartItem>,
    val totalPrice: Int,
    val address: String,
    val recipientName: String,
    val phone: String,
    val status: String = "Diproses" // "Diproses" atau "Selesai"
)