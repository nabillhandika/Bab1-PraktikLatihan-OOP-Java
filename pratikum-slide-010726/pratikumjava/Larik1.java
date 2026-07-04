import java.util.Scanner;

public class Larik1 {

    public static void main(String[] args) {

        Scanner masuk = new Scanner(System.in);
        float nilai[] = new float[5];

        System.out.println("Masukkan 5 buah data nilai");

        for (int i = 0; i < 5; i++) {
            System.out.print("Data ke-" + (i + 1) + " : ");
            nilai[i] = masuk.nextFloat();
        }

        System.out.println("Data nilai yang dimasukkan");

        for (int i = 0; i < 5; i++) {
            System.out.println(nilai[i]);
        }
    }
}