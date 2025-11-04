# WarungSkuy 🍜

<div align="center">

![WarungSkuy](https://img.shields.io/badge/WarungSkuy-Food%20Ordering-orange?style=for-the-badge&logo=android)
![Kotlin](https://img.shields.io/badge/Kotlin-1.9.0-purple?style=for-the-badge&logo=kotlin)
![Android](https://img.shields.io/badge/Android-14%2B-green?style=for-the-badge&logo=android)
![Jetpack Compose](https://img.shields.io/badge/Jetpack-Compose-blue?style=for-the-badge&logo=jetpackcompose)

**Aplikasi Pemesanan Makanan Warung Lokal dengan Desain Modern**

[Fitur](#-fitur-utama) • [Screenshots](#-screenshots) • [Instalasi](#-instalasi) • [Tech Stack](#-tech-stack) • [Arsitektur](#-struktur-aplikasi) • [Kontribusi](#-kontribusi)

</div>

## 🍽️ Tentang WarungSkuy

WarungSkuy adalah aplikasi pemesanan makanan Android modern yang dirancang khusus untuk warung makanan lokal. Dengan antarmuka yang intuitif dan desain modern berwarna orange yang khas, aplikasi ini memudahkan pelanggan untuk memesan makanan favorit mereka dengan cepat dan mudah. Dibangun menggunakan Kotlin, ViewBinding, dan Jetpack Compose dengan praktik pengembangan Android terkini, WarungSkuy menawarkan pengalaman memesan yang mulus dengan persistensi data lokal menggunakan SharedPreferences dan Gson.

## 📱 Screenshots

<div align="center">

### ✨ Autentikasi

| Splash Screen | Auth Choice | Register |
|---------------|-------------|----------|
| <img src="https://via.placeholder.com/200x400/FF6B35/FFFFFF?text=Splash" width="200" alt="Splash Screen"> | <img src="https://via.placeholder.com/200x400/FF6B35/FFFFFF?text=Auth+Choice" width="200" alt="Auth Choice"> | <img src="https://via.placeholder.com/200x400/FF6B35/FFFFFF?text=Register" width="200" alt="Register"> |

**Splash Screen** - Halaman pembuka dengan logo WarungSkuy<br>
**Auth Choice** - Pilihan untuk Login atau Register<br>
**Register** - Form pendaftaran dengan validasi lengkap

</div>

<div align="center">

| Login | Home | Menu Makanan |
|-------|------|--------------|
| <img src="https://via.placeholder.com/200x400/FF6B35/FFFFFF?text=Login" width="200" alt="Login"> | <img src="https://via.placeholder.com/200x400/FF6B35/FFFFFF?text=Home" width="200" alt="Home"> | <img src="https://via.placeholder.com/200x400/FF6B35/FFFFFF?text=Menu" width="200" alt="Menu"> |

**Login** - Halaman login dengan validasi<br>
**Home** - Halaman utama dengan informasi warung dan promo<br>
**Menu Makanan** - Katalog lengkap 12 menu dengan harga

</div>

<div align="center">

### 🛒 Pemesanan

| Keranjang | Alamat Pengiriman | Konfirmasi Pesanan |
|-----------|-------------------|-------------------|
| <img src="https://via.placeholder.com/200x400/FF6B35/FFFFFF?text=Cart" width="200" alt="Keranjang"> | <img src="https://via.placeholder.com/200x400/FF6B35/FFFFFF?text=Address" width="200" alt="Alamat"> | <img src="https://via.placeholder.com/200x400/FF6B35/FFFFFF?text=Confirmation" width="200" alt="Konfirmasi"> |

**Keranjang** - Management pesanan dengan kontrol kuantitas<br>
**Alamat Pengiriman** - Input informasi pengiriman lengkap<br>
**Konfirmasi Pesanan** - Review pesanan sebelum checkout

</div>

<div align="center">

### 📋 Riwayat & Profil

| Riwayat Pesanan | Detail Pesanan | Profil |
|-----------------|----------------|--------|
| <img src="https://via.placeholder.com/200x400/FF6B35/FFFFFF?text=History" width="200" alt="Riwayat"> | <img src="https://via.placeholder.com/200x400/FF6B35/FFFFFF?text=Detail" width="200" alt="Detail"> | <img src="https://via.placeholder.com/200x400/FF6B35/FFFFFF?text=Profile" width="200" alt="Profil"> |

**Riwayat Pesanan** - Daftar semua pesanan dengan status "Diproses"<br>
**Detail Pesanan** - Informasi lengkap pesanan dan pengiriman<br>
**Profil** - Informasi akun dan statistik pesanan

</div>

## ✨ Fitur Utama

### 🍜 Sistem Pemesanan Lengkap
- **Autentikasi User** - Login dan registrasi yang aman dengan validasi form
- **Session Management** - Manajemen sesi user dengan SharedPreferences
- **Menu Makanan** - 12 menu makanan Indonesia (Nasi Goreng, Sate Ayam, Bakso, dll)
- **Keranjang Belanja** - Tambah, kurang, dan hapus item dengan mudah
- **Checkout Cepat** - Input alamat pengiriman dan konfirmasi pesanan
- **Riwayat Pesanan** - Lihat semua pesanan dengan Order ID unik dan status tracking

### 🎨 Desain Modern & Intuitif
- **UI/UX Menarik** - Warna orange (#FF6B35) yang konsisten dengan layout clean
- **ViewBinding** - Type-safe view binding untuk performa optimal
- **Bottom Navigation** - Akses cepat ke Home, Produk, Pesanan, dan Profile
- **Form Validation** - Input validation untuk pengalaman yang lebih baik
- **RecyclerView** - Efficient list rendering dengan CardView

### 🔧 Teknologi Modern
- **Jetpack Compose** - Modern UI toolkit untuk Android
- **SharedPreferences** - Persistent local storage
- **Gson** - JSON serialization/deserialization
- **Glide** - Efficient image loading dan caching
- **Material Design** - Material Components untuk UI modern

## 🚀 Instalasi

### Prasyarat
- Android Studio Ladybug atau lebih baru
- Android SDK 36 (Android 14+)
- Kotlin 1.9.0+
- JDK 11 atau lebih tinggi
- Gradle 8.x

### Langkah Build
1. **Clone repository**
   ```bash
   git clone https://github.com/boriqq/WarungSkuys.git
   cd warungskuy
   ```

2. **Buka di Android Studio**
   - Buka Android Studio
   - Pilih "Open an existing project"
   - Navigasi ke direktori yang telah di-clone

3. **Sync Gradle**
   - Biarkan Android Studio melakukan sync Gradle
   - Pastikan semua dependencies berhasil di-download

4. **Build dan Run**
   - Hubungkan perangkat Android atau mulai emulator (Android 14+)
   - Klik "Run" atau tekan `Shift + F10`

## 🛠️ Tech Stack

### Teknologi Inti
- **Kotlin** - Bahasa pemrograman utama
- **Android SDK 36** - Target Android 14+
- **Jetpack Compose** - Modern declarative UI
- **ViewBinding** - Type-safe view references

### Library & Dependencies
```kotlin
// UI Components
implementation("androidx.recyclerview:recyclerview:1.3.2")
implementation("androidx.cardview:cardview:1.0.0")
implementation("com.google.android.material:material:1.11.0")

// Image Loading
implementation("com.github.bumptech.glide:glide:4.16.0")

// JSON Processing
implementation("com.google.code.gson:gson:2.10.1")

// Jetpack Compose
implementation(platform("androidx.compose:compose-bom"))
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")
implementation("androidx.activity:activity-compose")
```

### Arsitektur & Pola
- **Activity-based Architecture** - Multiple activities untuk different screens
- **Data Models** - Kotlin data classes untuk type safety
- **SessionManager Pattern** - Centralized session management
- **Singleton Pattern** - FoodData sebagai single source of truth

## 🏗️ Struktur Aplikasi

```
app/
├── src/main/
│   ├── java/com/example/warungskuy/
│   │   ├── activities/
│   │   │   ├── SplashActivity.kt          # Splash screen
│   │   │   ├── AuthChoiceActivity.kt      # Login/Register choice
│   │   │   ├── LoginActivity.kt           # Login screen
│   │   │   ├── RegisterActivity.kt        # Registration screen
│   │   │   ├── HomeActivity.kt            # Main home screen
│   │   │   ├── ProductsActivity.kt        # Products listing
│   │   │   ├── CartActivity.kt            # Shopping cart
│   │   │   ├── AddressActivity.kt         # Delivery address input
│   │   │   ├── ConfirmationActivity.kt    # Order confirmation
│   │   │   ├── HistoryActivity.kt         # Order history
│   │   │   ├── DetailHistoryActivity.kt   # Order detail
│   │   │   └── ProfileActivity.kt         # User profile
│   │   ├── adapters/
│   │   │   ├── FoodAdapter.kt             # RecyclerView adapter for food
│   │   │   ├── CartAdapter.kt             # RecyclerView adapter for cart
│   │   │   ├── HistoryAdapter.kt          # RecyclerView adapter for history
│   │   │   └── OrderSummaryAdapter.kt     # Order summary adapter
│   │   ├── models/
│   │   │   ├── User.kt                    # User data model
│   │   │   ├── Food.kt                    # Food item model
│   │   │   ├── CartItem.kt                # Cart item with quantity
│   │   │   └── OrderHistory.kt            # Order history model
│   │   ├── data/
│   │   │   └── FoodData.kt                # Static food data (12 items)
│   │   ├── utils/
│   │   │   └── SessionManager.kt          # Session & data management
│   │   └── ui/
│   │       └── theme/
│   │           ├── Color.kt               # App color palette
│   │           ├── Theme.kt               # App theme
│   │           └── Type.kt                # Typography
│   ├── res/
│   │   ├── drawable/                      # Images & icons
│   │   │   ├── logo_warungskuy.png
│   │   │   ├── nasi_goreng.jpg
│   │   │   ├── ayam_geprek.jpg
│   │   │   └── ... (12 food images)
│   │   ├── layout/                        # XML layouts
│   │   │   ├── activity_splash.xml
│   │   │   ├── activity_login.xml
│   │   │   ├── activity_home_new.xml
│   │   │   ├── activity_cart.xml
│   │   │   ├── item_food.xml
│   │   │   └── ... (all activity layouts)
│   │   ├── menu/
│   │   │   └── bottom_nav_menu.xml        # Bottom navigation menu
│   │   ├── values/
│   │   │   ├── colors.xml                 # Color definitions
│   │   │   ├── strings.xml                # String resources
│   │   │   └── themes.xml                 # App themes
│   │   └── mipmap/                        # App icons
│   └── AndroidManifest.xml
├── build.gradle.kts (Project)
├── build.gradle.kts (Module: app)
└── settings.gradle.kts
```

## 🎯 Fitur Teknis Detail

### 💾 Data Management
**SessionManager.kt** - Centralized data management:
- `setLogin(user)` & `logout()` - User authentication
- `saveUser(user)` & `getAllUsers()` - User registration
- `findUser(username, password)` - Login validation
- `saveCart(cart)` & `getCart()` - Cart persistence
- `saveOrderHistory(order)` & `getOrderHistory()` - Order tracking
- `clearCart()` - Cart cleanup after checkout

**Storage Technology:**
- SharedPreferences untuk persistent storage
- Gson untuk JSON serialization
- Type-safe data models

### 🎨 UI Components
- **RecyclerView** - Efficient list rendering untuk menu dan history
- **CardView** - Material design cards untuk food items
- **BottomNavigationView** - 4 tab navigation (Home, Produk, Pesanan, Profile)
- **TextInputLayout** - Material design text fields dengan validation
- **Custom Buttons** - Consistent orange theme buttons

### 📊 Business Logic
- **Order ID Generation** - Random 8-digit order number
- **Price Calculation** - Auto-calculate total berdasarkan quantity
- **Cart Management** - Add, update quantity, remove items
- **Form Validation** - Real-time validation untuk all inputs
- **Navigation Flow** - Proper activity stack management

## 📝 Menu Makanan

Aplikasi ini menyediakan 12 menu makanan tradisional Indonesia:

| No | Menu | Harga | Kategori |
|----|------|-------|----------|
| 1 | Nasi Goreng Spesial | Rp 25.000 | Nasi |
| 2 | Ayam Geprek Sambal Matah | Rp 20.000 | Ayam |
| 3 | Mie Ayam Bakso | Rp 18.000 | Mie |
| 4 | Sate Ayam (10 tusuk) | Rp 30.000 | Sate |
| 5 | Nasi Uduk Komplit | Rp 22.000 | Nasi |
| 6 | Soto Ayam | Rp 20.000 | Soto |
| 7 | Gado-Gado | Rp 15.000 | Sayur |
| 8 | Bakso Urat Jumbo | Rp 25.000 | Bakso |
| 9 | Pecel Lele | Rp 23.000 | Ikan |
| 10 | Ayam Bakar Madu | Rp 28.000 | Ayam |
| 11 | Es Teh Manis | Rp 5.000 | Minuman |
| 12 | Es Jeruk | Rp 7.000 | Minuman |

## 🔐 Keamanan & Best Practices

- **Input Validation** - Semua form di-validate sebelum submit
- **Password Storage** - Password disimpan di SharedPreferences (untuk production sebaiknya di-hash)
- **Session Management** - Proper login/logout flow
- **Error Handling** - Toast messages untuk user feedback
- **Activity Lifecycle** - Proper handling dengan finishAffinity()

## 🚧 Roadmap

### Version 2.0 (Planned)
- [ ] Integrasi Payment Gateway (Midtrans/Xendit)
- [ ] Real-time Order Tracking dengan Google Maps
- [ ] Push Notification untuk status pesanan
- [ ] Rating & Review sistem untuk setiap menu
- [ ] Wishlist/Favorite menu
- [ ] Promo Code & Discount system

### Future Enhancements
- [ ] Dark Mode support
- [ ] Multi-language support (EN/ID)
- [ ] Backend API integration (REST/GraphQL)
- [ ] Firebase Authentication
- [ ] Cloud Firestore database
- [ ] Admin panel untuk manage menu

## 🤝 Kontribusi

Kontribusi sangat diterima! Untuk berkontribusi:

1. Fork repository ini
2. Buat branch fitur baru (`git checkout -b feature/AmazingFeature`)
3. Commit perubahan Anda (`git commit -m 'Add some AmazingFeature'`)
4. Push ke branch (`git push origin feature/AmazingFeature`)
5. Buat Pull Request

### Guidelines Kontribusi
- Ikuti Kotlin coding conventions
- Tulis kode yang clean dan readable
- Tambahkan komentar untuk logika yang kompleks
- Test fitur sebelum submit PR
- Update README jika menambah fitur baru

## 📄 Lisensi

Project ini dilisensikan di bawah Lisensi MIT - lihat file [LICENSE](LICENSE) untuk detail.

## 👨‍💻 Developer

**Your Name**
- GitHub: [@boriqq](https://github.com/boriqq)
- Email: ariqalfarizii@gmail.com 

## 🙏 Acknowledgments

- Terimakasih kepada semua kontributor
- Food images dari berbagai sumber
- Inspirasi dari GoFood, GrabFood, dan aplikasi food delivery lainnya
- Material Design guidelines dari Google

## 📚 Dokumentasi Tambahan

### Setup Development Environment
```bash
# Clone repository
git clone https://github.com/boriqq/WarungSkuys.git

# Open with Android Studio
cd warungskuy
# Then: File → Open → Select warungskuy folder

# Run on emulator or device
# Make sure API level 36 (Android 14) is installed
```

### Troubleshooting
**Problem:** Gradle sync failed
**Solution:** Update Gradle wrapper: `./gradlew wrapper --gradle-version=8.x`

**Problem:** Images not showing
**Solution:** Pastikan semua drawable resources (12 food images) ada di `res/drawable/`

**Problem:** App crashes on launch
**Solution:** Check minSdk dan targetSdk di build.gradle.kts (should be 36)

---

<div align="center">

**⭐ Jangan lupa beri bintang pada repository ini jika Anda merasa terbantu!**

Dibangun dengan ❤️ menggunakan Kotlin dan Android

</div>

## 📞 Dukungan

Jika Anda memiliki pertanyaan atau membutuhkan bantuan:
- Buka issue di GitHub repository
- Email ke: support@warungskuy.com
- Atau hubungi melalui form kontak di aplikasi

**Informasi Warung:**
- 📍 Alamat: Jl. Cipadung No. 777, Bandung
- ⏰ Jam Operasional: 08.00 - 22.00 WIB
- 📞 Kontak: 0812-3456-7890

## 📈 Status Project

![Build Status](https://img.shields.io/badge/build-passing-brightgreen)
![Version](https://img.shields.io/badge/version-1.0.0-blue)
![License](https://img.shields.io/badge/license-MIT-green)
![Platform](https://img.shields.io/badge/platform-Android%2014%2B-green)
![Language](https://img.shields.io/badge/language-Kotlin-purple)

---

**WarungSkuy** - Pesan makanan warung favoritmu dengan mudah! 🍜✨

*"Makanan Enak, Harga Terjangkau"*
