package com.example.warungskuy.models

data class Food(
    val id: Int,
    val name: String,
    val price: Int,
    val imageRes: Int, // Resource ID untuk gambar
    val description: String = ""
)