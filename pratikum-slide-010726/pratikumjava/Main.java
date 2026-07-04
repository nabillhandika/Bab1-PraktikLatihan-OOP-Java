import java.util.Scanner;

public class Main {

    public void kalimat() {
        System.out.print("Isi matriks adalah : ");
    }

    public int hitungLuas(int p, int l) {
        int luas;
        luas = p * l;
        return luas;
    }

    public int hitungVolume(int p, int l, int t) {
        int volume;
        volume = p * l * t;
        return volume;
    }

    public static void main(String[] args) {

        int p, l, t;
        int data[];

        Scanner masuk = new Scanner(System.in);

        System.out.print("Masukkan panjang : ");
        p = masuk.nextInt();

        System.out.print("Masukkan lebar : ");
        l = masuk.nextInt();

        System.out.print("Masukkan tinggi : ");
        t = masuk.nextInt();

        data = new int[3];

        Main saya = new Main();

        data[0] = saya.hitungLuas(p, l);
        data[1] = saya.hitungVolume(p, l, t);
        data[2] = 10;

        saya.kalimat();

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
}