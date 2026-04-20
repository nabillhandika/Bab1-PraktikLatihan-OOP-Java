// Nama file: Hewan.java

public class Hewan {
    void suara() {
        System.out.println("Suara hewan");
    }
}

class Herbivora extends Hewan {
    @Override
    void suara() {
        System.out.println("Suara herbivora");
    }
}

class Karnivora extends Hewan {
    @Override
    void suara() {
        System.out.println("Suara karnivora");
    }
}

class Kelinci extends Herbivora {
    @Override
    void suara() {
        System.out.println("Suara kelinci");
    }
}