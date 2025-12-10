/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;

/**
 *
 * @author Ahmad Yusuf
 */

public class Mahasiswa {

    private int id;
    private String nama;
    private String nim;
    private int sks;
    private int jenisId;
    private int biaya;


    public Mahasiswa(String nama, String nim, int sks, int jenisId, int biaya) {
        this.nama = nama;
        this.nim = nim;
        this.sks = sks;
        this.jenisId = jenisId;
        this.biaya = biaya;
    }


    public Mahasiswa(int id, String nama, String nim, int sks, int jenisId, int biaya) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.sks = sks;
        this.jenisId = jenisId;
        this.biaya = biaya;
    }

   
    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public int getSks() {
        return sks;
    }

    public int getJenisId() {
        return jenisId;
    }

    public int getBiaya() {
        return biaya;
    }
}




