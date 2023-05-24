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

    public void deleteBarang(int id) {
        String sql = "DELETE FROM barang WHERE id_barang=?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }
    
    public void editNamaBarang(int id, String nama){
        String sql = "UPDATE barang SET nama = ? WHERE id_barang = ?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setString(1, nama);
            st.setInt(2, id);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertBarang(String nama, int jumlah, int idSupplier) {
        String sql = "INSERT INTO barang(nama, jumlah, id_supplier) VALUES (?, ?, ?)";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setString(1, nama);
            st.setInt(2, jumlah);
            st.setInt(3, idSupplier);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    
     public int getIdBarang(String name) {
        String sql = "SELECT id_barang FROM barang WHERE nama = ?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
            return 0;
    }

    public int getIdSupplier(int idBarang) {
        String sql = "SELECT id_supplier FROM barang WHERE id_barang = ?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setInt(1, idBarang);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
            return 0;
    }
    
    public Object[][] getList() {
        Object[][] data = new Object[super.getTotalData()][2];
        String sql = "SELECT id_barang, nama FROM " + super.table + " ORDER BY nama";
        int totalData = super.getTotalData();
        try {
            Connection koneksi = super.getKoneksi();
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int nomor = 0;
            while (rs.next()) {
                data[nomor][0] = rs.getInt(1);
                data[nomor][1] = rs.getString(2);
                nomor++;
            }
        } catch (Exception err) {
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
        String QUERY = "SELECT barang.id_barang, barang.nama, barang.jumlah, supplier.nama AS nama_supplier FROM barang INNER JOIN supplier USING(id_supplier) ORDER BY barang.id_barang";
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
