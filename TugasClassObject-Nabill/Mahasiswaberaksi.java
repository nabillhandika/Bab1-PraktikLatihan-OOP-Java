public class Mahasiswaberaksi {
    public static void main(String[] args) {
        Mahasiswa mhs1 = new Mahasiswa() ;
        mhs1.nama = "Nabill Handika Pratama";
        mhs1.nim = "I.2510128";

        Mahasiswa mhs2 = new Mahasiswa() ;
        mhs2.nama = "Andi Wijaya";
        mhs2.nim = "I.2510129";

        Mahasiswa mhs3 = new Mahasiswa(); 
        mhs3.nama = "Siti Aminah";
        mhs3.nim = "I.2510130";

        System.out.println("--- DATA MAHASISWA 1 ---");
        mhs1.tampilkanNama();
        mhs1.tampilkanNim();
        mhs1.olahraga();

        System.out.println("--- DATA MAHASISWA 2 ---");
        mhs2.tampilkanNama();
        mhs2.tampilkanNim();
        mhs2.olahraga();

        System.out.println("--- DATA MAHASISWA 3 ---");
        mhs3.tampilkanNama();
        mhs3.tampilkanNim();
        mhs3.olahraga();

    }
}
