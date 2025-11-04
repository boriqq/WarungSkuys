# 🍜 WarungSkuy - Aplikasi Pemesanan Makanan

<p align="center">
  <img src="https://img.shields.io/badge/Platform-Android-3DDC84?style=flat-square&logo=android&logoColor=white"/>
  <img src="https://img.shields.io/badge/Language-Kotlin-7F52FF?style=flat-square&logo=kotlin&logoColor=white"/>
  <img src="https://img.shields.io/badge/Min%20SDK-36-orange?style=flat-square"/>
  <img src="https://img.shields.io/badge/Build-Passing-success?style=flat-square"/>
  <img src="https://img.shields.io/badge/License-MIT-blue?style=flat-square"/>
</p>

<p align="center">
  <strong>Solusi Modern untuk Pemesanan Makanan Warung Lokal</strong><br>
  Dibangun dengan Kotlin & Material Design 3
</p>

---

## 📖 Deskripsi Proyek

**WarungSkuy** adalah aplikasi Android native yang memudahkan pelanggan memesan makanan dari warung lokal. Aplikasi ini menggabungkan kesederhanaan UI/UX modern dengan fitur lengkap sistem pemesanan, mulai dari autentikasi user hingga tracking riwayat pesanan. Dibangun menggunakan teknologi terkini seperti ViewBinding, SharedPreferences untuk data persistence, dan Gson untuk serialization, WarungSkuy menawarkan performa optimal dengan ukuran aplikasi yang ringan.

**Kenapa WarungSkuy?**
- Interface intuitif dengan warna tema orange yang eye-catching
- 12 menu makanan Indonesia dengan harga terjangkau
- Sistem keranjang belanja yang fleksibel
- Riwayat pesanan lengkap dengan Order ID unik
- Manajemen profil dan logout yang aman

---

## 🎯 Fitur Aplikasi

<table>
<tr>
<td width="50%">

### 🔐 Autentikasi & Profil
- Register akun baru dengan validasi form
- Login dengan username/password
- Session management otomatis
- Profil user dengan statistik pesanan
- Logout aman dengan konfirmasi

### 🛒 Pemesanan & Keranjang
- Browse 12 menu makanan Indonesia
- Add to cart dengan 1 klik
- Adjust quantity langsung di keranjang
- Remove item yang tidak diinginkan
- Real-time total price calculation

</td>
<td width="50%">

### 📦 Checkout & Pengiriman
- Form alamat pengiriman lengkap
- Validasi input untuk akurasi data
- Konfirmasi pesanan sebelum submit
- Generate Order ID otomatis
- Success dialog setelah order

### 📋 Riwayat & Tracking
- Daftar semua pesanan user
- Status pesanan (Diproses/Selesai)
- Detail lengkap setiap order
- Reorder untuk pesanan favorit
- Filter by date (coming soon)

</td>
</tr>
</table>

---

## 📸 Galeri Aplikasi

<details open>
<summary><b>🔓 Authentication Flow</b></summary>
<br>

| Splash & Welcome | Registrasi | Login |
|:---:|:---:|:---:|
| ![Splash](https://i.pinimg.com/736x/8f/84/91/8f849199cf8e9ac38c9c0d12b83a35ae.jpg) | ![Register](https://i.pinimg.com/736x/69/14/73/691473e7310ea28502e9937f04858f29.jpg) | ![Login](https://i.pinimg.com/736x/c1/bc/0a/c1bc0ad9f21a8072f30b2cc3663db1aa.jpg) |
| Halaman pembuka dengan branding | Form lengkap dengan validasi | Autentikasi user yang aman |

</details>

<details open>
<summary><b>🏠 Home & Menu</b></summary>
<br>

| Home Banner | Menu Makanan (1) | Menu Makanan (2) |
|:---:|:---:|:---:|
| ![Home](https://i.pinimg.com/736x/6f/5b/12/6f5b12036e20f117d8a38e767582a4e6.jpg) | ![Menu1](https://i.pinimg.com/736x/74/9a/2f/749a2f298a692cbd5d580f70ec440fa0.jpg) | ![Menu2](https://i.pinimg.com/736x/74/99/3a/74993afdfa263ca52fa143b300fc2195.jpg) |
| Info warung + promo spesial | Katalog 12 menu dengan harga | Scroll untuk lihat semua menu |

</details>

<details open>
<summary><b>🛍️ Shopping & Checkout</b></summary>
<br>

| Keranjang Belanja | Input Alamat | Konfirmasi Order |
|:---:|:---:|:---:|
| ![Cart](https://i.pinimg.com/736x/74/ac/40/74ac40e964b5e3b177bcacb87cd28b83.jpg) | ![Address](https://i.pinimg.com/736x/47/91/45/479145ee362e69432b09ab578d0a845b.jpg) | ![Confirm](https://i.pinimg.com/736x/be/08/b9/be08b95fa05bfab9b6660dc60fdd09df.jpg) |
| Manage qty & hapus item | Data penerima lengkap | Review sebelum pesan |

</details>

<details open>
<summary><b>📊 History & Profile</b></summary>
<br>

| Order History | Detail Pesanan | User Profile |
|:---:|:---:|:---:|
| ![History](https://i.pinimg.com/736x/f8/62/9e/f8629eb7c4e2ab74be727706b9564abe.jpg) | ![Detail](https://i.pinimg.com/736x/e8/61/04/e861042205948238ad8767203dbcee87.jpg) | ![Profile](https://i.pinimg.com/736x/74/c5/d4/74c5d45283d80218edf1b5867804e080.jpg) |
| List pesanan + status | Info lengkap + reorder | Data akun + logout |

</details>

---

## 🛠️ Teknologi & Dependencies

### Core Technologies
```kotlin
- Kotlin 1.9.0 - Modern programming language
- Android SDK 36 - Target Android 14+
- ViewBinding - Type-safe view access
- SharedPreferences - Local data persistence
- Gson 2.10.1 - JSON serialization
```

### UI Framework
```kotlin
- Material Design 3 - Modern UI components
- RecyclerView 1.3.2 - Efficient list rendering
- CardView 1.0.0 - Material cards
- ConstraintLayout - Flexible layouts
- Bottom Navigation - Tab navigation
```

### Image & Media
```kotlin
- Glide 4.16.0 - Image loading & caching
- Vector Drawables - Scalable icons
```

### Build Configuration
```kotlin
android {
    compileSdk = 36
    minSdk = 36
    targetSdk = 36
    
    buildFeatures {
        viewBinding = true
    }
}
```

---

## 🏗️ Arsitektur Proyek
```
📁 WarungSkuy/
│
├── 📂 app/src/main/
│   │
│   ├── 📂 java/com/example/warungskuy/
│   │   │
│   │   ├── 📂 activities/          (12 Activities)
│   │   │   ├── SplashActivity.kt
│   │   │   ├── AuthChoiceActivity.kt
│   │   │   ├── LoginActivity.kt
│   │   │   ├── RegisterActivity.kt
│   │   │   ├── HomeActivity.kt
│   │   │   ├── ProductsActivity.kt
│   │   │   ├── CartActivity.kt
│   │   │   ├── AddressActivity.kt
│   │   │   ├── ConfirmationActivity.kt
│   │   │   ├── HistoryActivity.kt
│   │   │   ├── DetailHistoryActivity.kt
│   │   │   └── ProfileActivity.kt
│   │   │
│   │   ├── 📂 adapters/            (4 Adapters)
│   │   │   ├── FoodAdapter.kt
│   │   │   ├── CartAdapter.kt
│   │   │   ├── HistoryAdapter.kt
│   │   │   └── OrderSummaryAdapter.kt
│   │   │
│   │   ├── 📂 models/              (4 Data Models)
│   │   │   ├── User.kt
│   │   │   ├── Food.kt
│   │   │   ├── CartItem.kt
│   │   │   └── OrderHistory.kt
│   │   │
│   │   ├── 📂 data/
│   │   │   └── FoodData.kt         (12 Menu Items)
│   │   │
│   │   └── 📂 utils/
│   │       └── SessionManager.kt   (Data Manager)
│   │
│   ├── 📂 res/
│   │   ├── 📂 drawable/            (Logo + 12 Food Images)
│   │   ├── 📂 layout/              (15+ XML Layouts)
│   │   ├── 📂 menu/                (Bottom Nav Menu)
│   │   ├── 📂 values/
│   │   │   ├── colors.xml
│   │   │   ├── strings.xml
│   │   │   └── themes.xml
│   │   └── 📂 mipmap/              (App Icons)
│   │
│   └── AndroidManifest.xml
│
├── build.gradle.kts (Project)
├── build.gradle.kts (Module: app)
└── settings.gradle.kts
```

---

## 🍽️ Daftar Menu

| ID | Nama Menu | Harga | Deskripsi |
|----|-----------|-------|-----------|
| 1️⃣ | **Nasi Goreng Spesial** | Rp 25.000 | Nasi goreng dengan telur, ayam, sayuran |
| 2️⃣ | **Ayam Geprek Sambal Matah** | Rp 20.000 | Ayam crispy dengan sambal pedas |
| 3️⃣ | **Mie Ayam Bakso** | Rp 18.000 | Mie ayam dengan bakso sapi pilihan |
| 4️⃣ | **Sate Ayam (10 tusuk)** | Rp 30.000 | Sate ayam bumbu kacang khas |
| 5️⃣ | **Nasi Uduk Komplit** | Rp 22.000 | Nasi uduk dengan lauk komplit |
| 6️⃣ | **Soto Ayam** | Rp 20.000 | Soto ayam kuah bening hangat |
| 7️⃣ | **Gado-Gado** | Rp 15.000 | Sayuran segar bumbu kacang |
| 8️⃣ | **Bakso Urat Jumbo** | Rp 25.000 | Bakso urat jumbo kuah segar |
| 9️⃣ | **Pecel Lele** | Rp 23.000 | Lele goreng crispy sambal terasi |
| 🔟 | **Ayam Bakar Madu** | Rp 28.000 | Ayam bakar saus madu manis |
| 1️⃣1️⃣ | **Es Teh Manis** | Rp 5.000 | Es teh manis segar |
| 1️⃣2️⃣ | **Es Jeruk** | Rp 7.000 | Es jeruk peras segar |

---

## 🚀 Cara Install & Run

### Prerequisites
- ✅ Android Studio Ladybug (atau lebih baru)
- ✅ JDK 11+
- ✅ Android SDK 36
- ✅ Gradle 8.x
- ✅ Emulator atau Physical Device (Android 14+)

### Installation Steps

**1. Clone Repository**
```bash
git clone https://github.com/boriqq/WarungSkuys.git
cd WarungSkuy
```

**2. Open Project**
- Buka Android Studio
- File → Open → Pilih folder `WarungSkuy`
- Wait for Gradle sync

**3. Build Project**
```bash
./gradlew clean build
```

**4. Run Application**
- Hubungkan device atau start emulator
- Click Run ▶️ atau tekan `Shift + F10`

### Troubleshooting

<details>
<summary><b>❌ Gradle Sync Failed</b></summary>
```bash
# Update Gradle Wrapper
./gradlew wrapper --gradle-version=8.2

# Clean & Rebuild
./gradlew clean
./gradlew build
```
</details>

<details>
<summary><b>❌ Images Not Showing</b></summary>

Pastikan semua file gambar ada di `res/drawable/`:
- `logo_warungskuy.png`
- `nasi_goreng.jpg` hingga `es_jeruk.jpg`
</details>

<details>
<summary><b>❌ App Crashes</b></summary>

Check `build.gradle.kts`:
```kotlin
minSdk = 36
targetSdk = 36
```
</details>

---

## 💾 Data Management

### SessionManager Features
```kotlin
// User Authentication
sessionManager.setLogin(user)      // Login user
sessionManager.logout()            // Logout & clear session
sessionManager.isLoggedIn()        // Check login status

// User Management
sessionManager.saveUser(user)      // Register new user
sessionManager.findUser(u, p)     // Validate login
sessionManager.getCurrentUser()    // Get logged user

// Cart Operations
sessionManager.saveCart(cart)      // Persist cart
sessionManager.getCart()           // Load cart
sessionManager.clearCart()         // Empty cart

// Order History
sessionManager.saveOrderHistory(order)  // Save order
sessionManager.getOrderHistory()        // Get all orders
```

### Data Storage Technology
- **SharedPreferences** - Lightweight key-value storage
- **Gson** - Convert objects to JSON string
- **Data Classes** - Type-safe model structures

---

## 🎨 Design System

### Color Palette
```xml
<!-- Primary Colors -->
<color name="primary">#EA6C5C</color>           <!-- Orange/Coral -->
<color name="primary_dark">#D4513E</color>      <!-- Darker Orange -->
<color name="accent">#F5B041</color>            <!-- Yellow/Gold -->
<color name="secondary">#76C147</color>         <!-- Green -->

<!-- Neutral Colors -->
<color name="background">#F8F9FA</color>        <!-- Light Gray -->
<color name="text_dark">#8B2E1F</color>         <!-- Dark Brown -->
<color name="white">#FFFFFF</color>
<color name="black">#1A1A1A</color>
```

### Typography
- **Title**: 24-28sp, Bold
- **Subtitle**: 18-20sp, Bold
- **Body**: 14-16sp, Regular
- **Caption**: 12-14sp, Regular

### Components
- **Cards**: 12dp corner radius, 4dp elevation
- **Buttons**: 56dp height, rounded corners
- **Icons**: 24dp standard size

---

## 🔒 Security & Best Practices

| Aspek | Implementation |
|-------|---------------|
| **Input Validation** | Real-time form validation dengan error messages |
| **Password Storage** | Saved di SharedPreferences (hash untuk production) |
| **Session Management** | Auto-login check, logout dengan konfirmasi |
| **Error Handling** | Try-catch blocks dengan user-friendly Toast |
| **Activity Stack** | Proper finish() dan finishAffinity() |
| **Memory Management** | ViewBinding untuk prevent memory leaks |

---

## 🗺️ Roadmap Pengembangan

### 🎯 Version 1.0 (Current)
- ✅ Complete authentication flow
- ✅ Menu browsing & cart system
- ✅ Checkout & order confirmation
- ✅ Order history with status
- ✅ User profile & logout

### 🚀 Version 2.0 (Planned)
- ⏳ Payment gateway integration (Midtrans)
- ⏳ Real-time order tracking
- ⏳ Push notifications
- ⏳ Rating & review system
- ⏳ Favorite/wishlist menu
- ⏳ Promo codes & discounts

### 🔮 Future Vision
- 📱 Dark mode theme
- 🌐 Multi-language (ID/EN)
- ☁️ Backend API (REST/GraphQL)
- 🔥 Firebase integration
- 📊 Analytics dashboard
- 👨‍💼 Admin panel

---

## 👥 Kontribusi

Kami welcome kontribusi dari siapa saja! Berikut cara berkontribusi:

### How to Contribute

1. **Fork** repository ini
2. **Clone** fork kamu
```bash
   git clone https://github.com/your-username/WarungSkuy.git
```
3. **Create branch** untuk fitur baru
```bash
   git checkout -b feature/amazing-feature
```
4. **Commit** perubahan kamu
```bash
   git commit -m "Add: amazing feature description"
```
5. **Push** ke branch
```bash
   git push origin feature/amazing-feature
```
6. **Open Pull Request** di GitHub

### Contribution Guidelines
- ✍️ Follow Kotlin coding conventions
- 📝 Write clear commit messages
- 🧪 Test before submitting PR
- 📖 Update documentation if needed
- 💬 Be respectful in discussions

---

## 📞 Kontak & Support

### Developer Contact
👤 **Your Name**  
📧 Email: ariqalfarizii@gmail.com  
🐙 GitHub: [@boriqq](https://github.com/boriqq)  
🔗 LinkedIn: [Your LinkedIn]

### Warung Information
📍 **Alamat**: Jl. Cipadung No. 777, Bandung  
⏰ **Jam Operasional**: 08.00 - 22.00 WIB (Setiap Hari)  
📱 **WhatsApp**: 0812-3456-7890  
📧 **Email**: support@warungskuy.com

### Get Support
- 🐛 **Bug Reports**: [Open an issue](https://github.com/boriqq/WarungSkuys/issues)
- 💡 **Feature Requests**: [Submit your idea](https://github.com/boriqq/WarungSkuys/issues)
- 📖 **Documentation**: Check README atau Wiki
- 💬 **Discussions**: Join GitHub Discussions

---

## 📄 License
```
MIT License

Copyright (c) 2025 WarungSkuy

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---

## 🙌 Acknowledgments

Terima kasih kepada:
- 🎨 **Material Design** - Design system dari Google
- 🖼️ **Unsplash & Pexels** - Free stock photos untuk food images
- 🍕 **GoFood, GrabFood** - Inspirasi UX flow
- 👨‍💻 **Kotlin Community** - Amazing resources & support
- 🏫 **Dosen & Teman-teman** - Feedback & testing

---

## 📊 Project Statistics

![GitHub Repo Size](https://img.shields.io/github/repo-size/boriqq/WarungSkuys?style=flat-square)
![GitHub Code Size](https://img.shields.io/github/languages/code-size/boriqq/WarungSkuys?style=flat-square)
![GitHub Last Commit](https://img.shields.io/github/last-commit/boriqq/WarungSkuys?style=flat-square)
![GitHub Issues](https://img.shields.io/github/issues/boriqq/WarungSkuys?style=flat-square)
![GitHub Stars](https://img.shields.io/github/stars/boriqq/WarungSkuys?style=social)

---

<div align="center">

### ⭐ Star Project Ini Jika Bermanfaat!

<img src="https://img.shields.io/badge/Made%20with-❤️-red?style=for-the-badge"/>
<img src="https://img.shields.io/badge/Built%20with-Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white"/>
<img src="https://img.shields.io/badge/Powered%20by-Android-3DDC84?style=for-the-badge&logo=android&logoColor=white"/>

**🍜 WarungSkuy - Makanan Enak, Harga Terjangkau! ✨**

[⬆ Back to Top](#-warungskuy---aplikasi-pemesanan-makanan)

</div>

---

*Last Updated: November 2025*  
*Version: 1.0.0*  
*Status: Active Development* 🚀
