package com.example.warungskuy.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.example.warungskuy.models.CartItem
import com.example.warungskuy.models.OrderHistory
import com.example.warungskuy.models.User

class SessionManager(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("WarungSkuyPrefs", Context.MODE_PRIVATE)
    private val gson = Gson()

    companion object {
        private const val KEY_IS_LOGGED_IN = "isLoggedIn"
        private const val KEY_USERNAME = "username"
        private const val KEY_FULL_NAME = "fullName"
        private const val KEY_PHONE = "phone"
        private const val KEY_USERS = "users"
        private const val KEY_CART = "cart"
        private const val KEY_HISTORY = "orderHistory"
    }

    // Login & Logout
    fun setLogin(user: User) {
        prefs.edit().apply {
            putBoolean(KEY_IS_LOGGED_IN, true)
            putString(KEY_USERNAME, user.username)
            putString(KEY_FULL_NAME, user.fullName)
            putString(KEY_PHONE, user.phone)
            apply()
        }
    }

    fun isLoggedIn(): Boolean = prefs.getBoolean(KEY_IS_LOGGED_IN, false)

    fun logout() {
        prefs.edit().apply {
            putBoolean(KEY_IS_LOGGED_IN, false)
            remove(KEY_USERNAME)
            remove(KEY_FULL_NAME)
            remove(KEY_PHONE)
            apply()
        }
        clearCart()
    }

    fun getCurrentUser(): User? {
        if (!isLoggedIn()) return null
        val username = prefs.getString(KEY_USERNAME, "") ?: ""
        val fullName = prefs.getString(KEY_FULL_NAME, "") ?: ""
        val phone = prefs.getString(KEY_PHONE, "") ?: ""
        return User(username, "", fullName, phone)
    }

    // User Management
    fun saveUser(user: User) {
        val users = getAllUsers().toMutableList()
        users.add(user)
        val json = gson.toJson(users)
        prefs.edit().putString(KEY_USERS, json).apply()
    }

    fun getAllUsers(): List<User> {
        val json = prefs.getString(KEY_USERS, null) ?: return emptyList()
        val type = object : TypeToken<List<User>>() {}.type
        return gson.fromJson(json, type)
    }

    fun findUser(username: String, password: String): User? {
        return getAllUsers().find {
            it.username == username && it.password == password
        }
    }

    // Cart Management
    fun saveCart(cart: List<CartItem>) {
        val json = gson.toJson(cart)
        prefs.edit().putString(KEY_CART, json).apply()
    }

    fun getCart(): MutableList<CartItem> {
        val json = prefs.getString(KEY_CART, null) ?: return mutableListOf()
        val type = object : TypeToken<MutableList<CartItem>>() {}.type
        return gson.fromJson(json, type)
    }

    fun clearCart() {
        prefs.edit().remove(KEY_CART).apply()
    }

    // Order History Management
    fun saveOrderHistory(order: OrderHistory) {
        val history = getOrderHistory().toMutableList()
        history.add(0, order) // Tambahin di paling atas
        val json = gson.toJson(history)
        prefs.edit().putString(KEY_HISTORY, json).apply()
    }

    fun getOrderHistory(): List<OrderHistory> {
        val json = prefs.getString(KEY_HISTORY, null) ?: return emptyList()
        val type = object : TypeToken<List<OrderHistory>>() {}.type
        return gson.fromJson(json, type)
    }
}