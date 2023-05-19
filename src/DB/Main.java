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
        Petugas db = new Petugas("petugas");
        Barang br = new Barang("barang");
        System.out.println(Arrays.toString(br.getDataBarangById(1)));
//        db.updatePassword("imam", "admin");
    }

}
