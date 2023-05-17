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
public class Barang extends Models {

    public Barang(String tableName) {
        super(tableName);
    }

    public Object[][] getDataBarang() {
        Object[][] data = new Object[super.getTotalData()][4];
        String QUERY = "SELECT barang.id_barang, barang.nama, barang.jumlah, supplier.nama AS nama_supplier FROM barang INNER JOIN supplier USING(id_supplier)";
        try {
            Connection koneksi = super.getKoneksi();
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(QUERY);
            int nomor = 0;
            while (rs.next()) {
                for (int i = 0, j = 1; i < 4; i++) {
                    data[nomor][i] = rs.getString(j);
                    j++;
                }
                nomor++;
            }
            return data;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return data;
    }
}
