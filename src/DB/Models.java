/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import tools.Config;

/**
 *
 * @author ASUS
 */
public class Models implements Database {

    protected String table;

    public Models() {
        String pisahTitik = this.getClass().toString();
        pisahTitik = pisahTitik.substring(pisahTitik.indexOf('.') + 1).toLowerCase();
        this.table = pisahTitik;
    }

    public Models(String tableName) {
        this.table = tableName;
    }

    @Override
    public int getTotalData() {
        String QUERY = "SELECT COUNT(\'*\') FROM " + table;
        try {
            Connection koneksi = getKoneksi();
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(QUERY);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getTotalColumn() {
        String QUERY = "SELECT * FROM " + table;
        try {
            Connection koneksi = getKoneksi();
            Statement st = koneksi.createStatement();
            ResultSet rs = st.executeQuery(QUERY);
            ResultSetMetaData metaData = rs.getMetaData();
            return metaData.getColumnCount();
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return 0;
    }

    @Override
    public Connection getKoneksi() {
        Connection koneksi = null;
        try {
            koneksi = DriverManager.getConnection("jdbc:mysql://localhost:" + Config.env("PORT") + "/" + Config.env("DATABASE_NAME"), Config.env("DB_USERNAME"), Config.env("DB_PASSWORD"));
            return koneksi;
        } catch (SQLException err) {
            err.printStackTrace();
        }
        return koneksi;
    }

    @Override
    public Object[][] selectAll() {
        String QUERY = "SELECT * FROM " + table;
        int totalData = this.getTotalData();
        int totalColumn = this.getTotalColumn();
        Object[][] data = new Object[totalData][totalColumn];
        try {
            Connection koneksi = this.getKoneksi();
            Statement statement = koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);
            int nomor = 0;
            while (resultSet.next()) {
                for (int i = 1, j = 0; i <= totalColumn; i++) {
                    data[nomor][j++] = resultSet.getString(i);
                }
                nomor++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return data;
    }
}
