package penyewa;

public class Penyewa {
    private String namaPenyewa;
    private String idPenyewa;
    private int jumlahSewa;
    private static final int BATAS_SEWA = 3;

    public Penyewa(String idPenyewa, String namaPenyewa) {
        this.idPenyewa   = idPenyewa;
        this.namaPenyewa = namaPenyewa;
        this.jumlahSewa  = 0;
    }

    // Encapsulation – getter saja, tidak ada setter langsung
    public String getNamaPenyewa() { return namaPenyewa; }
    public String getIdPenyewa()   { return idPenyewa; }
    public int getJumlahSewa()     { return jumlahSewa; }
    public int getBatasSewa()      { return BATAS_SEWA; }

    // Validasi: apakah masih bisa menyewa?
    public boolean bisaSewa() {
        return jumlahSewa < BATAS_SEWA;
    }

    public void tambahSewa() {
        if (bisaSewa()) jumlahSewa++;
    }

    public void kurangiSewa() {
        if (jumlahSewa > 0) jumlahSewa--;
    }

    public void tampilkanInfo() {
        System.out.println("------------------------------------------");
        System.out.println("ID Penyewa : " + idPenyewa);
        System.out.println("Nama       : " + namaPenyewa);
        System.out.println("Sewa aktif : " + jumlahSewa + " / " + BATAS_SEWA);
        System.out.println("Status     : " + (bisaSewa() ? "Bisa Sewa" : "Batas Tercapai"));
    }
}
