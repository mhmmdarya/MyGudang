/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import io.github.cdimascio.dotenv.Dotenv;

/**
 *
 * @author ASUS
 */
public class Config {
    public static String env(String variabelName){
        Dotenv dotenv = Dotenv.load();
        return dotenv.get(variabelName);
    }
}
