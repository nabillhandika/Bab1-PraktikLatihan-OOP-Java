class Bentuk {
    void gambar() {
        System.out.println("Menggambar Bentuk");
    }
}

class Segitiga extends Bentuk {
    @Override
    void gambar() {
        System.out.println("Menggambar segitiga");
    }
}

class Persegi extends Bentuk {
    @Override
    void gambar() {
        System.out.println("Menggambar persegi");
    }
}