/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class JenisMahasiswa {
    private int id;
    private String namaJenis;

    public JenisMahasiswa(int id, String namaJenis) {
        this.id = id;
        this.namaJenis = namaJenis;
    }

    public int getId() {
        return id;
    }

    public String getNamaJenis() {
        return namaJenis;
    }

    @Override
    public String toString() {
        return namaJenis; 
    }
}
