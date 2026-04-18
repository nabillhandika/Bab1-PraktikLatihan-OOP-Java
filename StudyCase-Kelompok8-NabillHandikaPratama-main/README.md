# 💻 Sistem Manajemen Penyewaan Alat

> Implementasi Konsep Object-Oriented Programming (OOP) dalam Java

---

## 📌 Deskripsi Proyek

Sistem Manajemen Penyewaan Alat adalah aplikasi berbasis Java yang mensimulasikan proses penyewaan berbagai jenis alat seperti **laptop, kamera, dan proyektor**.

Aplikasi ini dirancang sebagai studi kasus untuk mengimplementasikan konsep **Object-Oriented Programming (OOP)** secara terstruktur, modular, dan interaktif melalui menu berbasis input pengguna.

---

## 🎯 Tujuan Pengembangan

Proyek ini dibuat untuk memahami dan mengimplementasikan konsep inti OOP:

* 🔹 Class & Object
* 🔹 Encapsulation (data hiding & validasi)
* 🔹 Inheritance (pewarisan class)
* 🔹 Polymorphism (overriding & runtime behavior)
* 🔹 Abstraction (abstract class & method)

---

## 🗂️ Struktur Folder

```id="ark1"
alat/
├── item/
│   ├── Alat.java
│   ├── Laptop.java
│   ├── Kamera.java
│   └── Proyektor.java
├── penyewa/
│   └── Penyewa.java
└── MainAlat.java
```

📌 Struktur ini memisahkan:

* **Model data (item & penyewa)**
* **Logika utama (Main)**
  → mengikuti prinsip *separation of concerns*

---

## ⚙️ Spesifikasi Sistem

### 🔷 1. Abstract Class: `Alat`

Berfungsi sebagai superclass untuk semua jenis alat.

**Atribut:**

* `namaAlat`
* `kodeAlat`
* `sedangDisewa`

**Method utama:**

* `sewa()` → menyewa alat
* `kembalikan()` → mengembalikan alat
* `hitungBiaya(int hari)` → abstract
* `tampilkanInfo()` → menampilkan informasi alat

---

### 🔷 2. Subclass (Inheritance & Polymorphism)

| Class         | Atribut Tambahan | Biaya / Hari |
| ------------- | ---------------- | ------------ |
| 💻 Laptop     | merk             | Rp150.000-Rp250.000 |
| 📷 Kamera     | resolusiMP       | Rp100.000- Rp200.000 |
| 📽️ Proyektor | lumen            | Rp130.000-Rp200.000 |

📌 Setiap subclass:

* meng-override `hitungBiaya()`
* meng-override `tampilkanInfo()`

👉 Menunjukkan **polymorphism secara nyata**

---

### 🔷 3. Class `Penyewa` (Encapsulation)

**Atribut private:**

* `nama`
* `idPenyewa`
* `usia`
* `jumlahSewaSaatIni`

**Fitur:**

* Validasi data (nama & usia)
* Maksimal penyewaan: **2 alat**
* Method kontrol:

  * `bisaSewa()`
  * `tambahSewa()`
  * `kurangiSewa()`

---

## 🔄 Alur Sistem

Aplikasi berjalan menggunakan menu interaktif:

```id="menu1"
===== MENU =====
1. Tampilkan Alat
2. Sewa Alat
3. Kembalikan Alat
4. Hitung Biaya
5. Keluar
```

### ✨ Fitur Utama:

* Menampilkan daftar alat beserta status
* Penyewaan alat dengan validasi
* Pembatasan jumlah sewa per penyewa
* Pengembalian alat
* Perhitungan biaya berdasarkan jenis alat

---

## 💡 Implementasi Konsep OOP

| Konsep        | Implementasi                             |
| ------------- | ---------------------------------------- |
| Encapsulation | Atribut private pada `Penyewa`           |
| Inheritance   | `Laptop`, `Kamera`, `Proyektor` ← `Alat` |
| Polymorphism  | Override `hitungBiaya()`                 |
| Abstraction   | `Alat` sebagai abstract class            |

---

## ▶️ Cara Menjalankan

```id="run1"
javac -d . item/Alat.java item/Laptop.java item/Kamera.java item/Proyektor.java penyewa/Penyewa.java MainAlat.java
java alat.MainAlat
```

---

## ⚠️ Keterbatasan Sistem

* Data masih menggunakan array (belum database)
* Validasi input masih sederhana
* Relasi penyewa dan alat masih bersifat simulasi

---

## 👨‍💻 Author

* Aldia Riski Fauzi
* Ahmad Mozaya Putra
* Nindia Nur Artika
* Anita Noviyanti
* Ahmad Iqbal
* Nabil Handika Pratama
* Utsman Dhani Prasetyo
* Muhammad Abdul Haqsyist Al Anwar

---

## 📚 Lisensi

Kelompok 8 
