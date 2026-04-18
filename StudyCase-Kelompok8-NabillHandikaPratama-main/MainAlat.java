import item.Alat;
import item.Laptop;
import item.Kamera;
import item.Proyektor;
import penyewa.Penyewa;
import java.util.Scanner;

public class MainAlat {

    // ── Data global ──────────────────────────────────────────────────────────
    static Alat[] daftarAlat = {
        new Laptop   ("L001", "Laptop ASUS VivoBook", 150_000, "Intel i5",  8),
        new Laptop   ("L002", "Laptop MacBook Air",   200_000, "Apple M2", 16),
        new Kamera   ("K001", "Kamera Canon EOS M50", 175_000, 24, true),
        new Kamera   ("K002", "Kamera Sony A6400",    200_000, 26, false),
        new Proyektor("P001", "Proyektor Epson EB",   120_000, 3200, true)
    };

    static Penyewa[] daftarPenyewa = {
        new Penyewa("PNY001", "Budi Santoso"),
        new Penyewa("PNY002", "Sari Dewi")
    };

    static Scanner input = new Scanner(System.in);

    // ── Entry point ──────────────────────────────────────────────────────────
    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("   SISTEM MANAJEMEN PENYEWAAN ALAT");
        System.out.println("=========================================");

        boolean running = true;
        while (running) {
            tampilkanMenu();
            int pilihan = readInt("Pilih menu: ");

            switch (pilihan) {
                case 1 -> fiturDaftarAlat();
                case 2 -> fiturSewaAlat();
                case 3 -> fiturKembalikanAlat();
                case 4 -> fiturHitungBiaya();
                case 5 -> {
                    System.out.println("\nTerima kasih! Program selesai.");
                    running = false;
                }
                default -> System.out.println("[!] Pilihan tidak valid. Coba lagi.");
            }
        }
        input.close();
    }

    // ── Menu ─────────────────────────────────────────────────────────────────
    static void tampilkanMenu() {
        System.out.println("\n===== MENU RENTAL ALAT =====");
        System.out.println("1. Tampilkan Daftar Alat");
        System.out.println("2. Sewa Alat");
        System.out.println("3. Kembalikan Alat");
        System.out.println("4. Hitung Biaya");
        System.out.println("5. Keluar");
        System.out.println("============================");
    }

    // ── Fitur 1: Tampilkan Alat ───────────────────────────────────────────────
    static void fiturDaftarAlat() {
        System.out.println("\n===== DAFTAR ALAT =====");
        for (int i = 0; i < daftarAlat.length; i++) {
            System.out.println("\n[" + (i + 1) + "]");
            daftarAlat[i].tampilkanInfo();   // Polymorphism
        }
        System.out.println("------------------------------------------");
    }

    // ── Fitur 2: Sewa Alat ────────────────────────────────────────────────────
    static void fiturSewaAlat() {
        System.out.println("\n===== SEWA ALAT =====");

        // Pilih alat
        tampilkanDaftarAlatSingkat();
        int idxAlat = readInt("Pilih alat (nomor): ") - 1;
        if (!indexAlatValid(idxAlat)) return;

        Alat alat = daftarAlat[idxAlat];

        // Pilih penyewa
        tampilkanDaftarPenyewa();
        int idxPenyewa = readInt("Pilih penyewa (nomor): ") - 1;
        if (!indexPenyewaValid(idxPenyewa)) return;

        Penyewa penyewa = daftarPenyewa[idxPenyewa];

        // Validasi
        if (alat.isSedangDisewa()) {
            System.out.println("[!] Gagal: Alat sudah disewa.");
            return;
        }
        if (!penyewa.bisaSewa()) {
            System.out.println("[!] Gagal: Penyewa mencapai batas maksimum sewa ("
                               + penyewa.getBatasSewa() + " alat).");
            return;
        }

        // Proses
        alat.sewa();
        penyewa.tambahSewa();
        System.out.println("[✓] Berhasil! " + alat.getNamaAlat()
                           + " disewa oleh " + penyewa.getNamaPenyewa() + ".");
    }

    // ── Fitur 3: Kembalikan Alat ──────────────────────────────────────────────
    static void fiturKembalikanAlat() {
        System.out.println("\n===== KEMBALIKAN ALAT =====");

        tampilkanDaftarAlatSingkat();
        int idxAlat = readInt("Pilih alat yang dikembalikan (nomor): ") - 1;
        if (!indexAlatValid(idxAlat)) return;

        Alat alat = daftarAlat[idxAlat];

        if (!alat.isSedangDisewa()) {
            System.out.println("[!] Alat ini tidak sedang disewa.");
            return;
        }

        int keterlambatan = readInt("Lama keterlambatan (hari, 0 jika tepat waktu): ");

        // Pilih penyewa untuk dikurangi
        tampilkanDaftarPenyewa();
        int idxPenyewa = readInt("Penyewa yang mengembalikan (nomor): ") - 1;
        if (!indexPenyewaValid(idxPenyewa)) return;

        alat.kembalikan();
        daftarPenyewa[idxPenyewa].kurangiSewa();

        System.out.println("[✓] " + alat.getNamaAlat() + " berhasil dikembalikan.");
        if (keterlambatan > 0) {
            double denda = keterlambatan * alat.getHargaPerHari() * 0.5;
            System.out.printf("[!] Denda keterlambatan %d hari: Rp %.0f%n",
                              keterlambatan, denda);
        }
    }

    // ── Fitur 4: Hitung Biaya ─────────────────────────────────────────────────
    static void fiturHitungBiaya() {
        System.out.println("\n===== HITUNG BIAYA =====");

        tampilkanDaftarAlatSingkat();
        int idxAlat = readInt("Pilih alat (nomor): ") - 1;
        if (!indexAlatValid(idxAlat)) return;

        Alat alat = daftarAlat[idxAlat];
        int hari = readInt("Jumlah hari sewa: ");
        if (hari <= 0) {
            System.out.println("[!] Jumlah hari harus lebih dari 0.");
            return;
        }

        double biaya = alat.hitungBiaya(hari);  // Polymorphism
        System.out.println("\n--- Rincian Biaya ---");
        System.out.println("Alat       : " + alat.getNamaAlat());
        System.out.printf ("Harga/hari : Rp %.0f%n", alat.getHargaPerHari());
        System.out.println("Lama sewa  : " + hari + " hari");
        System.out.printf ("Total biaya: Rp %.0f%n", biaya);
    }

    // ── Helper: tampilan ringkas ──────────────────────────────────────────────
    static void tampilkanDaftarAlatSingkat() {
        System.out.println();
        for (int i = 0; i < daftarAlat.length; i++) {
            Alat a = daftarAlat[i];
            System.out.printf("[%d] %-28s | Rp %-10.0f | %s%n",
                i + 1,
                a.getNamaAlat(),
                a.getHargaPerHari(),
                a.isSedangDisewa() ? "Disewa" : "Tersedia");
        }
    }

    static void tampilkanDaftarPenyewa() {
        System.out.println();
        for (int i = 0; i < daftarPenyewa.length; i++) {
            Penyewa p = daftarPenyewa[i];
            System.out.printf("[%d] %-20s | Sewa: %d/%d%n",
                i + 1,
                p.getNamaPenyewa(),
                p.getJumlahSewa(),
                p.getBatasSewa());
        }
    }

    // ── Helper: validasi index ────────────────────────────────────────────────
    static boolean indexAlatValid(int idx) {
        if (idx < 0 || idx >= daftarAlat.length) {
            System.out.println("[!] Nomor alat tidak valid.");
            return false;
        }
        return true;
    }

    static boolean indexPenyewaValid(int idx) {
        if (idx < 0 || idx >= daftarPenyewa.length) {
            System.out.println("[!] Nomor penyewa tidak valid.");
            return false;
        }
        return true;
    }

    // ── Helper: baca integer aman ─────────────────────────────────────────────
    static int readInt(String prompt) {
        System.out.print(prompt);
        while (!input.hasNextInt()) {
            System.out.print("[!] Masukkan angka: ");
            input.next();
        }
        int val = input.nextInt();
        input.nextLine(); // flush newline
        return val;
    }
}
