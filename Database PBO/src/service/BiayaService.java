package service;


import model.*;

public class BiayaService {

    public BiayaKuliah getJenis(String jenis) {

        switch (jenis) {
            case "Reguler":
                return new Reguler();

            case "Beasiswa":
                return new Beasiswa();

            case "Internasional":
                return new Internasional();

            default:
                return null;
        }
    }
}
