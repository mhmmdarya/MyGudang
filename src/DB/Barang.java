/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Barang extends Models {

    public Barang(String tableName) {
        super(tableName);
    }

    public ArrayList<Object[]> findBarangByName(String name) {
        String sql = "SELECT barang.id_barang, barang.nama, barang.jumlah, supplier.nama AS nama_supplier FROM barang INNER JOIN supplier USING (id_supplier) WHERE barang.nama LIKE \'%" + name + "%\'";
        ArrayList<Object[]> data = new ArrayList<>();
        try {
            Connection koneksi = super.getKoneksi();
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String nama = rs.getString(2);
                int jumlah = rs.getInt(3);
                String namaSupplier = rs.getString(4);
                data.add(new Object[]{id, nama, jumlah, namaSupplier});
            }

        } catch (SQLException err) {
            err.printStackTrace();
        }
        return data;
    }

    public Object[] getDataBarangById(int id) {
        Object[] data = new Object[super.getTotalColumn()];
        String sql = "SELECT * FROM barang WHERE id_barang=?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            int nomor = 0;
            if (rs.next()) {
                for (int i = 1, j = 0; i <= super.getTotalColumn(); i++) {
                    data[j++] = rs.getString(i);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
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
