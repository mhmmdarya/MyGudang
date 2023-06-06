/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.*;
import tools.Security;

/**
 *
 * @author ASUS
 */
public class Petugas extends Models {

    public Petugas(String tableName) {
        super(tableName);
    }

    public String[] getDataUser(String username) {
        String[] hasil = new String[3];
        String QUERY = "SELECT id_petugas, nama, role FROM petugas WHERE username=?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(QUERY);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                hasil[0] = rs.getString(1);
                hasil[1] = rs.getString(2);
                hasil[2] = rs.getString(3);
            }
            koneksi.close();
            return hasil;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasil;
    }
    
    public void editProfile(int id, String[] data){
        String sql = "UPDATE petugas SET nama = ?, email = ?, username = ? WHERE id_petugas = ?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setString(1, data[0]);
            st.setString(2, data[1]);
            st.setString(3, data[2]);
            st.setInt(4, id);
            st.executeUpdate();
            koneksi.close();
        } catch (SQLException e) {
        }
    }
    
    public String[] getDataById(int id){
        String sql = "SELECT nama, email, username FROM petugas WHERE id_petugas = ?";
        String[] result = new String[3];
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                result[0] = rs.getString(1);
                result[1] = rs.getString(2);
                result[2] = rs.getString(3);
            }
            koneksi.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Object[][] getAllData() {
        Object[][] hasil = new Object[super.getTotalData()][6];
        String QUERY = "SELECT id_petugas, nama, jenis_kelamin, email, username, role FROM petugas";
        try {
            Connection koneksi = super.getKoneksi();
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(QUERY);
            int nomor = 0;
            while (rs.next()) {
                for (int i = 0, j = 1; i < 6; i++) {
                    hasil[nomor][i] = rs.getString(j);
                    j++;
                }
                nomor++;
            }
            koneksi.close();
            return hasil;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasil;
    }
    
    public void deletePetugas(int id) {
        String sql = "DELETE FROM petugas WHERE id_petugas=?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setInt(1, id);
            st.executeUpdate();
            koneksi.close();
        } catch (SQLException err) {
            err.printStackTrace();
        }
    }
    
    public void insertPetugas(String[] data){
        String sql = "INSERT INTO petugas(nama, jenis_kelamin, email, username, password, role) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setString(1, data[0]);
            st.setString(2, data[1]);
            st.setString(3, data[2]);
            st.setString(4, data[3]);
            st.setString(5, data[4]);
            st.setString(6, data[5]);
            st.executeUpdate();
            koneksi.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePassword(String username, String password) {
        String sql = "UPDATE petugas SET password = ? WHERE username = ?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            password = Security.hashPassword(password);
            st.setString(1, password);
            st.setString(2, username);
            st.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void updatePassword(int id, String password) {
        String sql = "UPDATE petugas SET password = ? WHERE id_petugas = ?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            password = Security.hashPassword(password);
            st.setString(1, password);
            st.setInt(2, id);
            st.execute();
            koneksi.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUser(String username, String email) {
        String sql = "SELECT * FROM petugas WHERE username=? AND email=?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setString(1, username);
            st.setString(2, email);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
            koneksi.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean checkUser(String username) {
        String sql = "SELECT * FROM petugas WHERE username=?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
            koneksi.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean confirmPassword(int id, String password){
        String sql = "SELECT * FROM petugas WHERE id_petugas = ? AND password = ?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setInt(1, id);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return true;
            }
            koneksi.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean authLogin(String username, String password) {
        password = Security.hashPassword(password);
        String QUERY = "SELECT username, password FROM " + super.table + " WHERE username=? AND password=?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(QUERY);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return Security.compareHash(password, rs.getString(2));
            }
            koneksi.close();
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return false;
    }
}
