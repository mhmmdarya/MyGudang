/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

/**
 *
 * @author ASUS
 */
public class Main {

    public static void main(String[] args) {
        String pass = "admi";
        String hash = Security.hashPassword("admin");
        if (Security.compareHash(pass, hash)) {
            System.out.println("Okee");
        } else {
            System.out.println("Gagal");
        }
    }
}
