public class RekursifFaktorial {

    public static void main(String[] args) {

        System.out.println("Nilai Faktorial 5 = " + hitungFaktorial(5));

    }

    public static int hitungFaktorial(int n) {

        if (n <= 1)
            return 1;
        else
            return n * hitungFaktorial(n - 1);

    }
}