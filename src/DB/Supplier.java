/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.util.HashMap;
import java.sql.*;

/**
 *
 * @author ASUS
 */
public class Supplier extends Models {

    public Supplier(String tableName) {
        super.table = tableName;
    }
    
    public int findId(String name){
//        Object[] data = new Object[super.getTotalColumn()];
        String sql = "SELECT id_supplier FROM supplier WHERE nama=?";
        try {
            Connection koneksi = super.getKoneksi();
            PreparedStatement st = koneksi.prepareCall(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            int nomor = 0;
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    public Object[][] getList() {
        Object[][] data = new Object[super.getTotalData()][2];
        String sql = "SELECT id_supplier, nama FROM " + super.table;
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
}
