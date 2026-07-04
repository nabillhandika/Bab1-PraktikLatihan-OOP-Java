public class ContohString {

    public static void main(String[] args) {

        byte data[] = new byte[6];

        data[0] = 64;
        data[1] = 65;
        data[2] = 66;
        data[3] = 67;
        data[4] = 68;
        data[5] = 69;

        String s1 = "Selamat Pagi";
        String s2 = new String("Good Morning");
        String s3 = new String(data);
        String s4 = new String(data, 2, 3);

        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        System.out.println("s3 = " + s3);
        System.out.println("s4 = " + s4);
    }
}