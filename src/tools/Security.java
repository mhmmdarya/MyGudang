/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

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
}
