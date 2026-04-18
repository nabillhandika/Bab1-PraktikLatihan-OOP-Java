package item;

public class Proyektor extends Alat {
    private int resolusiLumen;
    private boolean hdmi;

    public Proyektor(String kodeAlat, String namaAlat, double hargaPerHari,
                     int resolusiLumen, boolean hdmi) {
        super(kodeAlat, namaAlat, hargaPerHari);
        this.resolusiLumen = resolusiLumen;
        this.hdmi          = hdmi;
    }

    public int getResolusiLumen() { return resolusiLumen; }
    public boolean isHdmi()       { return hdmi; }

    // Polymorphism: surcharge Rp 30.000/hari untuk proyektor HDMI
    @Override
    public double hitungBiaya(int hari) {
        double surcharge = hdmi ? 30_000 : 0;
        return (getHargaPerHari() + surcharge) * hari;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Tipe       : Proyektor");
        System.out.println("Lumen      : " + resolusiLumen);
        System.out.println("HDMI       : " + (hdmi ? "Ya (+Rp 30.000/hari)" : "Tidak"));
    }
}
