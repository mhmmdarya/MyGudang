/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import tools.Converter;

/**
 *
 * @author ASUS
 */
public class BarangMasuk extends Models {

    public BarangMasuk(String tableName) {
        super(tableName);
    }

    @Override
    public Object[][] selectAll() {
        Object[][] data = new Object[super.getTotalData()][6];
        String sql = "SELECT barang_masuk.id_transaksi, barang_masuk.tanggal_masuk, barang_masuk.jumlah, barang.nama AS nama_barang, supplier.nama AS nama_supplier, petugas.nama AS nama_petugas\n"
                + "FROM barang_masuk\n"
                + "INNER JOIN barang ON barang_masuk.id_barang = barang.id_barang\n"
                + "INNER JOIN petugas ON barang_masuk.id_petugas = petugas.id_petugas\n"
                + "INNER JOIN supplier ON barang_masuk.id_supplier = supplier.id_supplier";
        try {
            Connection koneksi = super.getKoneksi();
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int nomor = 0;
            while (rs.next()) {
                int id = rs.getInt(1);
                String tanggal = rs.getString(2);
                int jml = rs.getInt(3);
                String namaBarang = rs.getString(4);
                String namaSupplier = rs.getString(5);
                String namaPetugas = rs.getString(6);
                data[nomor] = new Object[]{id, tanggal, jml, namaBarang, namaSupplier, namaPetugas};
                nomor++;
            }
        } catch (SQLException e) {
        }
        return data;
    }

    public ArrayList<Object[]> filter(String tanggalAwal, String tanggalAkhir) {
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        String sql = "SELECT barang_masuk.id_transaksi, barang_masuk.tanggal_masuk, barang_masuk.jumlah, barang.nama AS nama_barang, supplier.nama AS nama_supplier, petugas.nama AS nama_petugas\n"
                + "FROM barang_masuk\n"
                + "INNER JOIN barang ON barang_masuk.id_barang = barang.id_barang\n"
                + "INNER JOIN petugas ON barang_masuk.id_petugas = petugas.id_petugas\n"
                + "INNER JOIN supplier ON barang_masuk.id_supplier = supplier.id_supplier\n"
                + "WHERE barang_masuk.tanggal_masuk BETWEEN ? AND ?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setString(1, tanggalAwal);
            st.setString(2, tanggalAkhir);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String tanggal = rs.getString(2);
                int jml = rs.getInt(3);
                String namaBarang = rs.getString(4);
                String namaSupplier = rs.getString(5);
                String namaPetugas = rs.getString(6);
                data.add(new Object[]{id, tanggal, jml, namaBarang, namaSupplier, namaPetugas});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
    
    public int getTotalDataToday(){
        String sql = "SELECT COUNT(*) FROM barang_masuk WHERE tanggal_masuk = ?";
        String today = Converter.formatTanggal(new Date());
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setString(1, today);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
            return 0;
    }

    public void insert(int idBarang, String tanggal, int jumlah, int idSupplier, int idPetugas) {
        String sql = "INSERT INTO barang_masuk(id_barang, tanggal_masuk, jumlah, id_supplier, id_petugas) VALUES (?, ?, ?, ?, ?)";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setInt(1, idBarang);
            st.setString(2, tanggal);
            st.setInt(3, jumlah);
            st.setInt(4, idSupplier);
            st.setInt(5, idPetugas);
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
