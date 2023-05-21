/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author ASUS
 */
public class Converter {

    public static Object[][] convertArray(ArrayList<Object[]> data) {
        int totalData = data.size();
        Object[][] datas = new Object[data.size()][];
        for (int i = 0; i < datas.length; i++) {
            datas[i] = data.get(i);
        }
        return datas;
    }
    
    public static String formatTanggal(Date date) {
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        return formatDate.format(date);
    }
}
