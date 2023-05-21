/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.util.*;
import tools.Converter;
/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        BarangMasuk br = new BarangMasuk("barang_masuk");
        System.out.println(Arrays.deepToString(br.selectAll()));
    }

}
