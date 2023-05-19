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
        String[] hasil = new String[2];
        String QUERY = "SELECT nama, role FROM petugas WHERE username=?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(QUERY);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                hasil[0] = rs.getString(1);
                hasil[1] = rs.getString(2);
            }
            return hasil;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hasil;
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
    
    public boolean checkUser(String username, String email){
        String sql = "SELECT * FROM petugas WHERE username=? AND email=?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setString(1, username);
            st.setString(2, email);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return true;
            }
        } catch (SQLException e) {
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
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return false;
    }
}
