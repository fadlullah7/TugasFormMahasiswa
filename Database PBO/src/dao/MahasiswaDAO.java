package dao;

import db.DbConnection;
import model.Mahasiswa;
import java.io.*;
import java.sql.*;
import java.util.*;
import model.JenisMahasiswa;

public class MahasiswaDAO {

    private Connection conn;

    public MahasiswaDAO(Connection conn) {
        this.conn = conn;
    }

   public void insert(Mahasiswa m) {
    try {
        String sql = "INSERT INTO mahasiswa (nama, nim, sks, jenis_id, biaya) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, m.getNama());
        pst.setString(2, m.getNim());
        pst.setInt(3, m.getSks());
        pst.setInt(4, m.getJenisId());
        pst.setInt(5, m.getBiaya());

        pst.executeUpdate();
        pst.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
}



    public void update(Mahasiswa mhs) {
   String sql = "UPDATE mahasiswa SET nama = ?, nim = ?, sks = ?, jenis_id = ?, biaya = ? WHERE id = ?";


    try (PreparedStatement pst = conn.prepareStatement(sql)) {

        pst.setString(1, mhs.getNama());
        pst.setString(2, mhs.getNim());
        pst.setInt(3, mhs.getSks());
        pst.setInt(4, mhs.getJenisId());
        pst.setInt(5, mhs.getBiaya());
        pst.setInt(6, mhs.getId());

        pst.executeUpdate();

    } catch (SQLException e) {
        System.err.println("Gagal update mahasiswa: " + e.getMessage());
        e.printStackTrace();
    }
}
   

    public void delete(int id) {
        String sql = "DELETE FROM mahasiswa WHERE id=?";
        try (Connection con = DbConnection.connect();
             PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   public List<Object[]> getAllMahasiswa() {
    List<Object[]> list = new ArrayList<>();

    try {
        String sql = "SELECT m.id, m.nama, m.nim, m.sks, j.nama_jenis, m.biaya " +
                     "FROM mahasiswa m " +
                     "JOIN jenis_mahasiswa j ON m.jenis_id = j.id " +
                     "ORDER BY m.id ASC";

        PreparedStatement pst = conn.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            list.add(new Object[]{
                    rs.getInt("id"),         
                    rs.getString("nama"),
                    rs.getString("nim"),
                    rs.getInt("sks"),
                    rs.getString("nama_jenis"),
                    rs.getInt("biaya")
            });
        }

        rs.close();
        pst.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}

      public void uploadCSV(File file) throws Exception {

    String sql = "INSERT INTO mahasiswa (nama, nim) VALUES (?, ?)";

    try (Connection con = DbConnection.connect();
         BufferedReader br = new BufferedReader(new FileReader(file));
         PreparedStatement pst = con.prepareStatement(sql)) {

        con.setAutoCommit(false); 

        String line = br.readLine(); 

        while ((line = br.readLine()) != null) {

            String[] data = line.split(",");

            if (data.length < 2) continue; 

            pst.setString(1, data[0].trim());  
            pst.setString(2, data[1].trim()); 
            pst.addBatch();
        }

        pst.executeBatch();
        con.commit(); 

    } catch (Exception e) {
        throw new Exception("Gagal upload CSV: " + e.getMessage());
    }
}

     public ArrayList<JenisMahasiswa> getAllJenis() {
    ArrayList<JenisMahasiswa> list = new ArrayList<>();

    try (Connection conn = DbConnection.connect();
         PreparedStatement pst = conn.prepareStatement("SELECT id, nama_jenis FROM jenis_mahasiswa ORDER BY id ASC");
         ResultSet rs = pst.executeQuery()) {

        while (rs.next()) {
            list.add(new JenisMahasiswa(
                    rs.getInt("id"),
                    rs.getString("nama_jenis")
            ));
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return list;
}

}
