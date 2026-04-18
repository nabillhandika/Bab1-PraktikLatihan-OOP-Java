# Database Java CRUD System - Nabill Handika Pratama (I.2510128)

## 📌 Deskripsi Proyek
Proyek ini adalah aplikasi Desktop berbasis Java yang mengimplementasikan sistem **CRUD (Create, Read, Update, Delete)** untuk manajemen data karyawan menggunakan Java Swing dan JDBC MySQL.

---

## 🛠️ Arsitektur & Teknologi
* **Bahasa Pemrograman**: Java 17 (LTS)
* **GUI Framework**: Java Swing & FlatLaf
* **Build Tool**: Apache Maven
* **Database**: MySQL 8.0 / MariaDB

---

## 🏗️ Struktur Project
* `src/main/java/javatutorial/`: Kode sumber aplikasi.
* `nabill_db.sql`: Skema database.
* `assets/`: Folder bukti pengujian.

---

## 🚀 Panduan Instalasi & Penggunaan
1. Aktifkan MySQL di XAMPP.
2. Import `nabill_db.sql` ke phpMyAdmin.
3. Jalankan perintah:
```bash
mvn compile exec:java "-Dexec.mainClass=javatutorial.Main"
