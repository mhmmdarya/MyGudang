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
            while (rs.next()) {
                for (int i = 0; i < data.length; i++) {
                    data[i][0] = rs.getInt(1);
                    data[i][1] = rs.getString(2);
                    data[i][2] = rs.getString(3);
                    data[i][3] = rs.getString(4);
                }
            }
            return data;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return data;
    }
}
