package com.example.warungskuy.models

data class User(
    val username: String,
    val password: String,
    val fullName: String,
    val phone: String = ""
)