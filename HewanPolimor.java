// Nama file: HewanPolimor.java

public class HewanPolimor {
    public static void main(String[] args) {
        Hewan hewan1 = new Hewan();
        Hewan hewan2 = new Herbivora();
        Hewan hewan3 = new Karnivora();
        Hewan hewan4 = new Kelinci(); 

        hewan1.suara();
        hewan2.suara();
        hewan3.suara();
        hewan4.suara();
    }
}