package item;

public abstract class Alat {
    private String namaAlat;
    private String kodeAlat;
    private double hargaPerHari;
    protected boolean sedangDisewa;

    public Alat(String kodeAlat, String namaAlat, double hargaPerHari) {
        this.kodeAlat    = kodeAlat;
        this.namaAlat    = namaAlat;
        this.hargaPerHari = hargaPerHari;
        this.sedangDisewa = false;
    }

    // Getters (Encapsulation)
    public String getNamaAlat()     { return namaAlat; }
    public String getKodeAlat()     { return kodeAlat; }
    public double getHargaPerHari() { return hargaPerHari; }
    public boolean isSedangDisewa() { return sedangDisewa; }

    // Setter
    public void setHargaPerHari(double harga) { this.hargaPerHari = harga; }

    // Proses sewa & kembali
    public void sewa() {
        this.sedangDisewa = true;
    }

    public void kembalikan() {
        this.sedangDisewa = false;
    }

    // Abstract – wajib di-override (Polymorphism)
    public abstract double hitungBiaya(int hari);

    // Polymorphism: tiap subclass boleh override
    public void tampilkanInfo() {
        System.out.println("------------------------------------------");
        System.out.println("Kode       : " + kodeAlat);
        System.out.println("Nama       : " + namaAlat);
        System.out.printf ("Harga/hari : Rp %.0f%n", hargaPerHari);
        System.out.println("Status     : " + (sedangDisewa ? "Sedang Disewa" : "Tersedia"));
    }
}
