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
            if(rs.next()){
                hasil[0] = rs.getString(1);
                hasil[1] = rs.getString(2);
            }

        } catch (Exception e) {
        }
        return hasil;
    }

    public boolean authLogin(String username, String password) {
        String QUERY = "SELECT * FROM " + super.table + " WHERE username=? AND password=?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(QUERY);
            st.setString(1, username);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return false;
    }
}
