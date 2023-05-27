/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB;
import java.sql.Connection;
/**
 *
 * @author ASUS
 */
public interface Database {

    public Object[][] selectAll();

    public int getTotalColumn();

    public int getTotalData();
    
    public Connection getKoneksi();
}
