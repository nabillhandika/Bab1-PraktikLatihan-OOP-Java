package item;

public class Laptop extends Alat {
    private String processor;
    private int ramGb;

    public Laptop(String kodeAlat, String namaAlat, double hargaPerHari,
                  String processor, int ramGb) {
        super(kodeAlat, namaAlat, hargaPerHari);
        this.processor = processor;
        this.ramGb     = ramGb;
    }

    public String getProcessor() { return processor; }
    public int getRamGb()        { return ramGb; }

    // Polymorphism: diskon 10% jika sewa >= 3 hari
    @Override
    public double hitungBiaya(int hari) {
        double total = getHargaPerHari() * hari;
        if (hari >= 3) total *= 0.90;
        return total;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Tipe       : Laptop");
        System.out.println("Processor  : " + processor);
        System.out.println("RAM        : " + ramGb + " GB");
        if (ramGb >= 3) System.out.println("Info       : Diskon 10% jika sewa >= 3 hari");
    }
}
