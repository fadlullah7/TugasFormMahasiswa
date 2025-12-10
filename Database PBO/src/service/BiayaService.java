/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

public class BiayaService {

    public int hitungBiaya(String jenis, int sks) {

        if (jenis == null) return 0;

        switch (jenis) {
            case "Reguler":
                return sks * 150000;

            case "Beasiswa":
                return (int) (sks * 150000 * 0.5);

            case "Internasional":
                return (sks * 300000) + 5000000;

            default:
                return 0;
        }
    }
}
