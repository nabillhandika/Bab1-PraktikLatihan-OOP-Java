class Manusia extends MakhlukHidup {
    @Override
    public void bernapas() { // Ubah F jadi P
        System.out.println("Manusia bernapas dengan paru-paru");
    }
}

class Hewan extends MakhlukHidup {
    @Override
    public void bernapas() { // Ubah F jadi P
        System.out.println("Hewan bernapas dengan berbagai cara");
    }
}