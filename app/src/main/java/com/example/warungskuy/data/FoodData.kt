package com.example.warungskuy.data

import com.example.warungskuy.models.Food
import com.example.warungskuy.R

object FoodData {
    fun getFoodList(): List<Food> {
        return listOf(
            Food(
                id = 1,
                name = "Nasi Goreng Spesial",
                price = 25000,
                imageRes = R.drawable.nasi_goreng,  // ← Ganti ini!
                description = "Nasi goreng dengan telur, ayam, dan sayuran segar"
            ),
            Food(
                id = 2,
                name = "Ayam Geprek Sambal Matah",
                price = 20000,
                imageRes = R.drawable.ayam_geprek,  // ← Ganti ini!
                description = "Ayam crispy dengan sambal matah pedas"
            ),
            Food(
                id = 3,
                name = "Mie Ayam Bakso",
                price = 18000,
                imageRes = R.drawable.mie_ayam,  // ← Dan seterusnya...
                description = "Mie ayam dengan bakso sapi pilihan"
            ),
            Food(
                id = 4,
                name = "Sate Ayam (10 tusuk)",
                price = 30000,
                imageRes = R.drawable.sate_ayam,
                description = "Sate ayam dengan bumbu kacang khas"
            ),
            Food(
                id = 5,
                name = "Nasi Uduk Komplit",
                price = 22000,
                imageRes = R.drawable.nasi_uduk,
                description = "Nasi uduk dengan lauk komplit"
            ),
            Food(
                id = 6,
                name = "Soto Ayam",
                price = 20000,
                imageRes = R.drawable.soto_ayam,
                description = "Soto ayam kuah bening hangat"
            ),
            Food(
                id = 7,
                name = "Gado-Gado",
                price = 15000,
                imageRes = R.drawable.gado_gado,
                description = "Sayuran segar dengan bumbu kacang"
            ),
            Food(
                id = 8,
                name = "Bakso Urat Jumbo",
                price = 25000,
                imageRes = R.drawable.baso,
                description = "Bakso urat jumbo dengan kuah segar"
            ),
            Food(
                id = 9,
                name = "Pecel Lele",
                price = 23000,
                imageRes = R.drawable.pecel_lele,
                description = "Lele goreng crispy dengan sambal terasi"
            ),
            Food(
                id = 10,
                name = "Ayam Bakar Madu",
                price = 28000,
                imageRes = R.drawable.ayam_bakar,
                description = "Ayam bakar dengan saus madu manis"
            ),
            Food(
                id = 11,
                name = "Es Teh Manis",
                price = 5000,
                imageRes = R.drawable.es_teh,
                description = "Es teh manis segar"
            ),
            Food(
                id = 12,
                name = "Es Jeruk",
                price = 7000,
                imageRes = R.drawable.es_jeruk,
                description = "Es jeruk peras segar"
            )
        )
    }
}