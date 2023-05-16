/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.*;

/**
 *
 * @author ASUS
 */
public class Models {

    protected String table;

    public Models() {
        String pisahTitik = this.getClass().toString();
        pisahTitik = pisahTitik.substring(pisahTitik.indexOf('.') + 1).toLowerCase();
        this.table = pisahTitik;
        System.out.println(getKoneksi());
        System.out.println(table);
    }

    public Models(String tableName) {
        this.table = tableName;
    }

    protected Connection getKoneksi() {
        Connection koneksi = null;
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/gudang", "root", "");
            System.out.println("Berhasil Konek");
            return koneksi;
        } catch (SQLException err) {
            System.out.println("Gagal Konek");
            err.printStackTrace();
        }
        return koneksi;
    }

    protected void selectAll() {
        String QUERY = "SELECT * FROM barang";
        try {
            Connection koneksi = this.getKoneksi();
            Statement statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);
            while (resultSet.next()) {
                String nama = resultSet.getString("nama");
                String jumlah = resultSet.getString("jumlah");

                System.out.println("Kolom 1: " + nama + ", Kolom 2: " + jumlah);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void show() {
        System.out.println(this.table);
    }

}
