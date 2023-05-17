/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author ASUS
 */
public class Security {

    public static boolean validatePassword(char[] password) {
        for (int i = 0; i < password.length; i++) {
            if (password[i] >= 32 && password[i] <= 47) {
                return true;
            }
        }
        return false;
    }

    public static String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            StringBuilder stringBuilder = new StringBuilder();
            for (byte hashedByte : hashedBytes) {
                stringBuilder.append(String.format("%02x", hashedByte));
            }

            return stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
   /**
    * Ini adalah method untuk membandingkan apakah String input merupakah hasil dari hash menggunakan SHA-256
    * 
    * @param input String input
    * @param hash Hash
    * @return true or false
    * 
    */
    public static boolean compareHash(String input, String hash){
        String rs = hashPassword(input);
        return rs.equals(hash);
    }
}
