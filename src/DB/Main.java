/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;

import java.util.Arrays;

/**
 *
 * @author ASUS
 */
public class Main {
    
    public static void main(String[] args) {
        BarangKeluar br = new BarangKeluar("barang_keluar");
        System.out.println(Arrays.deepToString(br.selectAll()));
        
    }
    
}
