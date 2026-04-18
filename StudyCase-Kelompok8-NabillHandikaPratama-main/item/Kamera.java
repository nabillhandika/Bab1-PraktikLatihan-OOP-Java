package item;

public class Kamera extends Alat {
    private int megapixel;
    private boolean adaLensa;

    public Kamera(String kodeAlat, String namaAlat, double hargaPerHari,
                  int megapixel, boolean adaLensa) {
        super(kodeAlat, namaAlat, hargaPerHari);
        this.megapixel = megapixel;
        this.adaLensa  = adaLensa;
    }

    public int getMegapixel()  { return megapixel; }
    public boolean isAdaLensa() { return adaLensa; }

    // Polymorphism: tambah biaya Rp 50.000/hari jika paket dengan lensa
    @Override
    public double hitungBiaya(int hari) {
        double biayaLensa = adaLensa ? 50_000 : 0;
        return (getHargaPerHari() + biayaLensa) * hari;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Tipe       : Kamera");
        System.out.println("Megapixel  : " + megapixel + " MP");
        System.out.println("Lensa      : " + (adaLensa ? "Termasuk (+Rp 50.000/hari)" : "Tidak termasuk"));
    }
}
