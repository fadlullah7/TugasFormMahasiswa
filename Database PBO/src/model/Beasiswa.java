package model;

public class Beasiswa extends BiayaKuliah {

    @Override
    public int hitung(int sks) {
        return (int) (sks * 150000 * 0.5);
    }
}

