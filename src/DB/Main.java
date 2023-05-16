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
        Petugas petugas = new Petugas("petugas");
        System.out.println(Arrays.toString(petugas.getDataUser("admin")));
    }
}
