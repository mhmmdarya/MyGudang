/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;
import io.github.cdimascio.dotenv.*;

/**
 *
 * @author ASUS
 */
public class Main {
    public static void main(String[] args) {
        Dotenv env = Dotenv.load();
        System.out.println(env.get("NAMA"));
    }
}
