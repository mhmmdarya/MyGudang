/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.*;
import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import tools.Converter;

/**
 *
 * @author ASUS
 */
public class BarangKeluar extends Models {

    public BarangKeluar(String tableName) {
        super.table = tableName;
    }

    public boolean insert(int idBarang, String tanggal, int jumlah, int idPetugas) {
        String sql = "INSERT INTO barang_keluar(id_barang, tanggal_keluar, jumlah, id_petugas) VALUES (?, ?, ?, ?)";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setInt(1, idBarang);
            st.setString(2, tanggal);
            st.setInt(3, jumlah);
            st.setInt(4, idPetugas);
            st.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }

    }

    public int getTotalDataToday() {
        String sql = "SELECT COUNT(*) FROM barang_keluar WHERE tanggal_keluar = ?";
        String today = Converter.formatTanggal(new java.util.Date());
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setString(1, today);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return 0;
    }

    public ArrayList<Object[]> filter(String tanggalAwal, String tanggalAkhir) {
        ArrayList<Object[]> data = new ArrayList<Object[]>();
        String sql = "SELECT barang_keluar.id_transaksi, barang_keluar.tanggal_keluar, barang_keluar.jumlah, barang.nama AS nama_barang, petugas.nama AS nama_petugas\n"
                + "FROM barang_keluar \n"
                + "INNER JOIN barang ON barang_keluar.id_barang = barang.id_barang\n"
                + "INNER JOIN petugas ON barang_keluar.id_petugas = petugas.id_petugas\n"
                + "WHERE barang_keluar.tanggal_keluar BETWEEN ? AND ?";
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
                String namaPetugas = rs.getString(5);
                data.add(new Object[]{id, tanggal, jml, namaBarang, namaPetugas});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public Object[][] selectAll() {
        Object[][] data = new Object[super.getTotalData()][5];
        String sql = "SELECT barang_keluar.id_transaksi, barang_keluar.tanggal_keluar, barang_keluar.jumlah, barang.nama AS nama_barang, petugas.nama AS nama_petugas\n"
                + "FROM barang_keluar \n"
                + "INNER JOIN barang ON barang_keluar.id_barang = barang.id_barang\n"
                + "INNER JOIN petugas ON barang_keluar.id_petugas = petugas.id_petugas";
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
                String namaPetugas = rs.getString(5);
                data[nomor] = new Object[]{id, tanggal, jml, namaBarang, namaPetugas};
                nomor++;
            }
        } catch (SQLException e) {
        }
        return data;
    }
}
